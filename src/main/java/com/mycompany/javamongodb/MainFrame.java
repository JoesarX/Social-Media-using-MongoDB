/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.javamongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.Border;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author josue
 */
public class MainFrame extends javax.swing.JFrame {

    //THE COLOR THEME FOR GENERATED RESOURCES
    Color IsaTheme = new Color(248, 147, 245);

    //ARRAYLIST FOR THE FOLLOW REQUEST PROFILES
    public ArrayList<ProfileItem> followRequests = new ArrayList<ProfileItem>();
    public ArrayList<ProfileItem> postsBoxes = new ArrayList<ProfileItem>();
    public ArrayList<searchItem> searchItems = new ArrayList<searchItem>();
    public ArrayList<postItem> postItemz = new ArrayList<postItem>();
    public ArrayList<postItem> feedItemz = new ArrayList<postItem>();
    public ArrayList<JButton> commentBotonz = new ArrayList<JButton>();
    public ArrayList<JButton> verCommentBotonz = new ArrayList<JButton>();
    public ArrayList<JButton> repostBotonz = new ArrayList<JButton>();
    //public ArrayList<
    public MongoClient client = MongoClients.create("mongodb://localhost:27017");
    public int yy = 0;
    public boolean feedOn = true;
    public String currentuser = "";
    public String currentFriend = "";

    static ConnectionString connString = new ConnectionString("mongodb://localhost:27017");
    static CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
    static CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
    static MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connString)
            .codecRegistry(codecRegistry)
            .retryWrites(true)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    static MongoCollection<Users> userss;
    static MongoCollection<Posts> posts;
    static MongoCollection<Comments> comms;
    public boolean actualuwu = false;
    List<Comments> commsies;
    List<Posts> ListPosts;
    List<Users> ListUsus;
    ArrayList<Users> usuariosss = new ArrayList();
    ArrayList<Comments> commenties = new ArrayList();
    ArrayList<Posts> posties = new ArrayList();
    public MongoDatabase db = mongoClient.getDatabase("Mini_RS");
    public MongoCollection<Document> users = db.getCollection("Users");
    public String propic = "";
    public String background = "";

    public MainFrame() {
        initComponents();
        borders();
        initiateSearchArrayList();
        Connection CC = new Connection();
        CC.createConnection();

        fetchPosts();

        for (int i = 0; i < usuariosss.size(); i++) {
            System.out.println(usuariosss.get(i));
            propic = usuariosss.get(i).getIadrPropic();
            background = usuariosss.get(i).getKadrBack();
        }
        yy = panelProfile.getHeight();
        //fotoProfile.setIcon(pruebaFoto(1, fichero.toString()));
        //fotoBanner.setIcon(pruebaFoto(3, fichero.toString()));
        /*Date newDate = new Date();
        Date newDate2 = new Date("Sun Nov 20 2022 14:33:29 ");
        System.out.println(newDate);
        System.out.println(newDate2);
        System.out.println();*/

 /*postItem postt = new postItem(5, 5, mainContentPanel.getWidth() - 10, 180, "josueespinalsanz@gmail.com", "Josue Edgardo Espinal Ara", "aaaaaaaaaaaaa aaaaaaaaa a \n asdasd \n sakdjlwjh as dad sajh w d aks \n  asijdlkjahw das \n alskjd lkwa\n aklsdjhlkasd \n alsdkjsaw   aa aaaadsa a sdjkahwdjlkhashd kajwhdkjlas dkjashd kjashdaskjdh askjdh askjldh kmjabd kjaqwkid haskj;dnkjaw hdjk;awd","Sun Nov 20 14:33:29 GMT-06:00 2022");
        feedPanel.add(postt.getPanelPost());
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "HomePage");*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewPostDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPostJT = new javax.swing.JTextArea();
        panelIMG = new javax.swing.JPanel();
        panelFoto = new javax.swing.JLabel();
        newTweet2 = new javax.swing.JButton();
        newTweet1 = new javax.swing.JButton();
        ViewCommentsDialog = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        searchBoton1 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        SignInPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        SIemail = new javax.swing.JTextField();
        SIboton = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        SIpass = new javax.swing.JPasswordField();
        SUboton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SignUpPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        SUemail = new javax.swing.JTextField();
        SignUpBoton = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        SUname = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        SUsur = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        SUpass = new javax.swing.JPasswordField();
        SUboton1 = new javax.swing.JLabel();
        SUbd = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        HomePage = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        signOutBoton = new javax.swing.JLabel();
        refreshBoton = new javax.swing.JLabel();
        homeBoton = new javax.swing.JLabel();
        searchBoton = new javax.swing.JLabel();
        newTweet = new javax.swing.JButton();
        profileBoton = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainContentPanel = new javax.swing.JPanel();
        scrollFeed = new javax.swing.JScrollPane();
        feedPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        commentBoton0 = new javax.swing.JButton();
        commentBoton1 = new javax.swing.JButton();
        commentBoton2 = new javax.swing.JButton();
        commentBoton3 = new javax.swing.JButton();
        commentBoton4 = new javax.swing.JButton();
        commentBoton5 = new javax.swing.JButton();
        commentBoton6 = new javax.swing.JButton();
        commentBoton7 = new javax.swing.JButton();
        commentBoton8 = new javax.swing.JButton();
        commentBoton9 = new javax.swing.JButton();
        commentBoton10 = new javax.swing.JButton();
        commentBoton11 = new javax.swing.JButton();
        commentBoton12 = new javax.swing.JButton();
        commentBoton13 = new javax.swing.JButton();
        commentBoton14 = new javax.swing.JButton();
        commentBoton15 = new javax.swing.JButton();
        commentBoton16 = new javax.swing.JButton();
        commentBoton17 = new javax.swing.JButton();
        commentBoton18 = new javax.swing.JButton();
        commentBoton19 = new javax.swing.JButton();
        vercommentBoton0 = new javax.swing.JButton();
        vercommentBoton1 = new javax.swing.JButton();
        vercommentBoton2 = new javax.swing.JButton();
        vercommentBoton3 = new javax.swing.JButton();
        vercommentBoton4 = new javax.swing.JButton();
        vercommentBoton5 = new javax.swing.JButton();
        vercommentBoton6 = new javax.swing.JButton();
        vercommentBoton7 = new javax.swing.JButton();
        vercommentBoton8 = new javax.swing.JButton();
        vercommentBoton9 = new javax.swing.JButton();
        vercommentBoton10 = new javax.swing.JButton();
        vercommentBoton11 = new javax.swing.JButton();
        vercommentBoton12 = new javax.swing.JButton();
        vercommentBoton13 = new javax.swing.JButton();
        vercommentBoton14 = new javax.swing.JButton();
        vercommentBoton15 = new javax.swing.JButton();
        vercommentBoton16 = new javax.swing.JButton();
        vercommentBoton17 = new javax.swing.JButton();
        vercommentBoton18 = new javax.swing.JButton();
        vercommentBoton19 = new javax.swing.JButton();
        repostBoton0 = new javax.swing.JButton();
        repostBoton1 = new javax.swing.JButton();
        repostBoton2 = new javax.swing.JButton();
        repostBoton3 = new javax.swing.JButton();
        repostBoton4 = new javax.swing.JButton();
        repostBoton5 = new javax.swing.JButton();
        repostBoton6 = new javax.swing.JButton();
        repostBoton7 = new javax.swing.JButton();
        repostBoton8 = new javax.swing.JButton();
        repostBoton9 = new javax.swing.JButton();
        repostBoton10 = new javax.swing.JButton();
        repostBoton11 = new javax.swing.JButton();
        repostBoton12 = new javax.swing.JButton();
        repostBoton13 = new javax.swing.JButton();
        repostBoton14 = new javax.swing.JButton();
        repostBoton15 = new javax.swing.JButton();
        repostBoton16 = new javax.swing.JButton();
        repostBoton17 = new javax.swing.JButton();
        repostBoton18 = new javax.swing.JButton();
        repostBoton19 = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        searchBar = new javax.swing.JTextField();
        SIboton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        profileSearch0 = new javax.swing.JPanel();
        searchBoton0 = new javax.swing.JButton();
        searchNombre0 = new javax.swing.JLabel();
        searchFoto0 = new javax.swing.JLabel();
        searchEmail0 = new javax.swing.JLabel();
        profileSearch1 = new javax.swing.JPanel();
        searchBoton2 = new javax.swing.JButton();
        searchNombre1 = new javax.swing.JLabel();
        searchFoto1 = new javax.swing.JLabel();
        searchEmail1 = new javax.swing.JLabel();
        profileSearch2 = new javax.swing.JPanel();
        searchBoton3 = new javax.swing.JButton();
        searchNombre2 = new javax.swing.JLabel();
        searchFoto2 = new javax.swing.JLabel();
        searchEmail2 = new javax.swing.JLabel();
        profileSearch3 = new javax.swing.JPanel();
        searchBoton4 = new javax.swing.JButton();
        searchNombre3 = new javax.swing.JLabel();
        searchFoto3 = new javax.swing.JLabel();
        searchEmail3 = new javax.swing.JLabel();
        profileSearch4 = new javax.swing.JPanel();
        searchBoton5 = new javax.swing.JButton();
        searchNombre4 = new javax.swing.JLabel();
        searchFoto4 = new javax.swing.JLabel();
        searchEmail4 = new javax.swing.JLabel();
        profileSearch5 = new javax.swing.JPanel();
        searchBoton6 = new javax.swing.JButton();
        searchNombre5 = new javax.swing.JLabel();
        searchFoto5 = new javax.swing.JLabel();
        searchEmail5 = new javax.swing.JLabel();
        profileSearch6 = new javax.swing.JPanel();
        searchBoton7 = new javax.swing.JButton();
        searchNombre6 = new javax.swing.JLabel();
        searchFoto6 = new javax.swing.JLabel();
        searchEmail6 = new javax.swing.JLabel();
        profileSearch7 = new javax.swing.JPanel();
        searchBoton8 = new javax.swing.JButton();
        searchNombre7 = new javax.swing.JLabel();
        searchFoto7 = new javax.swing.JLabel();
        searchEmail7 = new javax.swing.JLabel();
        profileSearch8 = new javax.swing.JPanel();
        searchBoton9 = new javax.swing.JButton();
        searchNombre8 = new javax.swing.JLabel();
        searchFoto8 = new javax.swing.JLabel();
        searchEmail8 = new javax.swing.JLabel();
        profileView = new javax.swing.JScrollPane();
        panelProfile = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        fotoProfile = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        fotoBanner = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        newBio1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        newBio = new javax.swing.JButton();
        ConfigurarCuentaButton = new javax.swing.JButton();
        posts1 = new javax.swing.JButton();
        reposts2 = new javax.swing.JButton();
        newFollowScroll = new javax.swing.JScrollPane();
        newFollowPanel = new javax.swing.JPanel();
        newTweet3 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();

        NewPostDialog.setBackground(new java.awt.Color(20, 20, 20));

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));

        textPostJT.setBackground(new java.awt.Color(56, 56, 56));
        textPostJT.setColumns(20);
        textPostJT.setFont(new java.awt.Font("Roboto", 0, 22)); // NOI18N
        textPostJT.setForeground(new java.awt.Color(255, 255, 255));
        textPostJT.setLineWrap(true);
        textPostJT.setRows(5);
        jScrollPane1.setViewportView(textPostJT);

        panelIMG.setBackground(new java.awt.Color(56, 56, 56));
        panelIMG.setForeground(new java.awt.Color(56, 56, 56));

        javax.swing.GroupLayout panelIMGLayout = new javax.swing.GroupLayout(panelIMG);
        panelIMG.setLayout(panelIMGLayout);
        panelIMGLayout.setHorizontalGroup(
            panelIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
            .addGroup(panelIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
        );
        panelIMGLayout.setVerticalGroup(
            panelIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
        );

        newTweet2.setBackground(new java.awt.Color(228, 147, 245));
        newTweet2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        newTweet2.setForeground(new java.awt.Color(0, 0, 0));
        newTweet2.setText("Elegir Imagen");
        newTweet2.setBorder(null);
        newTweet2.setFocusPainted(false);
        newTweet2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newTweet2MouseClicked(evt);
            }
        });
        newTweet2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTweet2ActionPerformed(evt);
            }
        });

        newTweet1.setBackground(new java.awt.Color(228, 147, 245));
        newTweet1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        newTweet1.setForeground(new java.awt.Color(0, 0, 0));
        newTweet1.setText("Post");
        newTweet1.setBorder(null);
        newTweet1.setFocusPainted(false);
        newTweet1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newTweet1MouseClicked(evt);
            }
        });
        newTweet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTweet1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(newTweet2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newTweet1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(panelIMG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(newTweet1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newTweet2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout NewPostDialogLayout = new javax.swing.GroupLayout(NewPostDialog.getContentPane());
        NewPostDialog.getContentPane().setLayout(NewPostDialogLayout);
        NewPostDialogLayout.setHorizontalGroup(
            NewPostDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        NewPostDialogLayout.setVerticalGroup(
            NewPostDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(20, 20, 20));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(40, 40, 40));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane2.setViewportView(jTextArea1);

        searchBoton1.setBackground(new java.awt.Color(20, 20, 20));
        searchBoton1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        searchBoton1.setForeground(new java.awt.Color(228, 147, 245));
        searchBoton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchBoton1.setText("COMMENTS");
        searchBoton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchBoton1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(searchBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ViewCommentsDialogLayout = new javax.swing.GroupLayout(ViewCommentsDialog.getContentPane());
        ViewCommentsDialog.getContentPane().setLayout(ViewCommentsDialogLayout);
        ViewCommentsDialogLayout.setHorizontalGroup(
            ViewCommentsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ViewCommentsDialogLayout.setVerticalGroup(
            ViewCommentsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewCommentsDialogLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(44, 47, 51));

        MainPanel.setBackground(new java.awt.Color(44, 47, 51));
        MainPanel.setForeground(new java.awt.Color(44, 47, 51));
        MainPanel.setLayout(new java.awt.CardLayout());

        SignInPanel.setBackground(new java.awt.Color(20, 20, 20));
        SignInPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(20, 20, 20));

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(228, 147, 245));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Please enter your details.");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel24.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(228, 147, 245));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("EMAIL:");

        SIemail.setBackground(new java.awt.Color(64, 64, 64));
        SIemail.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SIemail.setForeground(new java.awt.Color(255, 255, 255));
        SIemail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SIemail.setAutoscrolls(false);
        SIemail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        SIemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIemailActionPerformed(evt);
            }
        });

        SIboton.setBackground(new java.awt.Color(228, 147, 245));
        SIboton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SIboton.setForeground(new java.awt.Color(0, 0, 0));
        SIboton.setText("SIGN IN");
        SIboton.setBorder(null);
        SIboton.setFocusPainted(false);
        SIboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SIbotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SIbotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SIbotonMouseExited(evt);
            }
        });
        SIboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIbotonActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(228, 147, 245));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("PASSWORD:");

        SIpass.setBackground(new java.awt.Color(64, 64, 64));
        SIpass.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SIpass.setForeground(new java.awt.Color(255, 255, 255));
        SIpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        SIpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIpassActionPerformed(evt);
            }
        });

        SUboton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SUboton.setForeground(new java.awt.Color(228, 147, 245));
        SUboton.setText("Sign Up");
        SUboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SUbotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SUbotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SUbotonMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Don't have an account?");

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(228, 147, 245));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Welcome back");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SIemail, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(229, 229, 229)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(SIboton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SUboton))
                            .addComponent(SIpass, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SIemail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SIpass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(SIboton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUboton)
                    .addComponent(jLabel2))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        SignInPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 540, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotologin2.jpg"))); // NOI18N
        SignInPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, -1, 820));

        MainPanel.add(SignInPanel, "SignInPanel");
        SignInPanel.getAccessibleContext().setAccessibleName("SignInPanel");

        SignUpPanel.setBackground(new java.awt.Color(20, 20, 20));
        SignUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(20, 20, 20));

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(228, 147, 245));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("SIGN UP");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(228, 147, 245));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("EMAIL:");

        SUemail.setBackground(new java.awt.Color(64, 64, 64));
        SUemail.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SUemail.setForeground(new java.awt.Color(255, 255, 255));
        SUemail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SUemail.setAutoscrolls(false);
        SUemail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        SUemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUemailActionPerformed(evt);
            }
        });

        SignUpBoton.setBackground(new java.awt.Color(228, 147, 245));
        SignUpBoton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SignUpBoton.setForeground(new java.awt.Color(0, 0, 0));
        SignUpBoton.setText("SIGN UP");
        SignUpBoton.setBorder(null);
        SignUpBoton.setFocusPainted(false);
        SignUpBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUpBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignUpBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignUpBotonMouseExited(evt);
            }
        });
        SignUpBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpBotonActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(228, 147, 245));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("PASSWORD:");

        SUname.setBackground(new java.awt.Color(64, 64, 64));
        SUname.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SUname.setForeground(new java.awt.Color(255, 255, 255));
        SUname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SUname.setAutoscrolls(false);
        SUname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        SUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUnameActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(228, 147, 245));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("FIRST NAMES:");

        SUsur.setBackground(new java.awt.Color(64, 64, 64));
        SUsur.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SUsur.setForeground(new java.awt.Color(255, 255, 255));
        SUsur.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SUsur.setAutoscrolls(false);
        SUsur.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        SUsur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUsurActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(228, 147, 245));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("LAST NAMES:");

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(228, 147, 245));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("BIRTHDAY:");

        SUpass.setBackground(new java.awt.Color(64, 64, 64));
        SUpass.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SUpass.setForeground(new java.awt.Color(255, 255, 255));
        SUpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        SUpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUpassActionPerformed(evt);
            }
        });

        SUboton1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        SUboton1.setForeground(new java.awt.Color(228, 147, 245));
        SUboton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SUboton1.setText("X");
        SUboton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SUboton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SUboton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SUboton1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(SignUpBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SUpass, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(SUemail, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SUsur, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SUname, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SUbd, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(SUboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SUboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(28, 28, 28)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SUemail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SUpass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SUname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel21)
                .addGap(6, 6, 6)
                .addComponent(SUsur, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SUbd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(SignUpBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        SignUpPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 540, 830));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sing2OP2_1.png"))); // NOI18N
        jLabel3.setToolTipText("");
        SignUpPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 580, 830));

        MainPanel.add(SignUpPanel, "SignUpPanel");
        SignUpPanel.getAccessibleContext().setAccessibleName("SignUpPanel");

        HomePage.setBackground(new java.awt.Color(20, 20, 20));

        jPanel7.setBackground(new java.awt.Color(20, 20, 20));

        signOutBoton.setBackground(new java.awt.Color(20, 20, 20));
        signOutBoton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        signOutBoton.setForeground(new java.awt.Color(255, 102, 102));
        signOutBoton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signOutBoton.setText("SIGN OUT");
        signOutBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOutBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signOutBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signOutBotonMouseExited(evt);
            }
        });

        refreshBoton.setBackground(new java.awt.Color(20, 20, 20));
        refreshBoton.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        refreshBoton.setForeground(new java.awt.Color(228, 147, 245));
        refreshBoton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refreshBoton.setText("REFRESH");
        refreshBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshBotonMouseExited(evt);
            }
        });

        homeBoton.setBackground(new java.awt.Color(20, 20, 20));
        homeBoton.setFont(new java.awt.Font("Roboto", 1, 21)); // NOI18N
        homeBoton.setForeground(new java.awt.Color(228, 147, 245));
        homeBoton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeBoton.setText("Home");
        homeBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBotonMouseClicked(evt);
            }
        });

        searchBoton.setBackground(new java.awt.Color(20, 20, 20));
        searchBoton.setFont(new java.awt.Font("Roboto", 0, 21)); // NOI18N
        searchBoton.setForeground(new java.awt.Color(228, 147, 245));
        searchBoton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchBoton.setText("Search");
        searchBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBotonMouseClicked(evt);
            }
        });

        newTweet.setBackground(new java.awt.Color(228, 147, 245));
        newTweet.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        newTweet.setForeground(new java.awt.Color(0, 0, 0));
        newTweet.setText("New Post");
        newTweet.setBorder(null);
        newTweet.setFocusPainted(false);
        newTweet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newTweetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newTweetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newTweetMouseExited(evt);
            }
        });
        newTweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTweetActionPerformed(evt);
            }
        });

        profileBoton.setBackground(new java.awt.Color(20, 20, 20));
        profileBoton.setFont(new java.awt.Font("Roboto", 0, 21)); // NOI18N
        profileBoton.setForeground(new java.awt.Color(228, 147, 245));
        profileBoton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileBoton.setText("Profile");
        profileBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileBotonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homeBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(newTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(refreshBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signOutBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(profileBoton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signOutBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBoton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainContentPanel.setBackground(new java.awt.Color(20, 20, 20));
        mainContentPanel.setLayout(new java.awt.CardLayout());

        feedPanel.setBackground(new java.awt.Color(30, 30, 30));
        feedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feedPanelMouseClicked(evt);
            }
        });

        jLabel4.setText("FEED");

        commentBoton0.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton0.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton0.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton0.setText("Comment");
        commentBoton0.setBorder(null);
        commentBoton0.setFocusPainted(false);
        commentBoton0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton0.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton0MouseClicked(evt);
            }
        });

        commentBoton1.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton1.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton1.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton1.setText("Comment");
        commentBoton1.setBorder(null);
        commentBoton1.setFocusPainted(false);
        commentBoton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton1.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton1MouseClicked(evt);
            }
        });
        commentBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton1ActionPerformed(evt);
            }
        });

        commentBoton2.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton2.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton2.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton2.setText("Comment");
        commentBoton2.setBorder(null);
        commentBoton2.setFocusPainted(false);
        commentBoton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton2.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                commentBoton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                commentBoton2MouseExited(evt);
            }
        });
        commentBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton2ActionPerformed(evt);
            }
        });

        commentBoton3.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton3.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton3.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton3.setText("Comment");
        commentBoton3.setBorder(null);
        commentBoton3.setFocusPainted(false);
        commentBoton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton3.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton3MouseClicked(evt);
            }
        });
        commentBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton3ActionPerformed(evt);
            }
        });

        commentBoton4.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton4.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton4.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton4.setText("Comment");
        commentBoton4.setBorder(null);
        commentBoton4.setFocusPainted(false);
        commentBoton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton4.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton4MouseClicked(evt);
            }
        });
        commentBoton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton4ActionPerformed(evt);
            }
        });

        commentBoton5.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton5.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton5.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton5.setText("Comment");
        commentBoton5.setBorder(null);
        commentBoton5.setFocusPainted(false);
        commentBoton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton5.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton5MouseClicked(evt);
            }
        });
        commentBoton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton5ActionPerformed(evt);
            }
        });

        commentBoton6.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton6.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton6.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton6.setText("Comment");
        commentBoton6.setBorder(null);
        commentBoton6.setFocusPainted(false);
        commentBoton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton6.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton6MouseClicked(evt);
            }
        });
        commentBoton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton6ActionPerformed(evt);
            }
        });

        commentBoton7.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton7.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton7.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton7.setText("Comment");
        commentBoton7.setBorder(null);
        commentBoton7.setFocusPainted(false);
        commentBoton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton7.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton7MouseClicked(evt);
            }
        });
        commentBoton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton7ActionPerformed(evt);
            }
        });

        commentBoton8.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton8.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton8.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton8.setText("Comment");
        commentBoton8.setBorder(null);
        commentBoton8.setFocusPainted(false);
        commentBoton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton8.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton8MouseClicked(evt);
            }
        });
        commentBoton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton8ActionPerformed(evt);
            }
        });

        commentBoton9.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton9.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton9.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton9.setText("Comment");
        commentBoton9.setBorder(null);
        commentBoton9.setFocusPainted(false);
        commentBoton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton9.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton9MouseClicked(evt);
            }
        });
        commentBoton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton9ActionPerformed(evt);
            }
        });

        commentBoton10.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton10.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton10.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton10.setText("Comment");
        commentBoton10.setBorder(null);
        commentBoton10.setFocusPainted(false);
        commentBoton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton10.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton10MouseClicked(evt);
            }
        });
        commentBoton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton10ActionPerformed(evt);
            }
        });

        commentBoton11.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton11.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton11.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton11.setText("Comment");
        commentBoton11.setBorder(null);
        commentBoton11.setFocusPainted(false);
        commentBoton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton11.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton11MouseClicked(evt);
            }
        });
        commentBoton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton11ActionPerformed(evt);
            }
        });

        commentBoton12.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton12.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton12.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton12.setText("Comment");
        commentBoton12.setBorder(null);
        commentBoton12.setFocusPainted(false);
        commentBoton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton12.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton12MouseClicked(evt);
            }
        });
        commentBoton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton12ActionPerformed(evt);
            }
        });

        commentBoton13.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton13.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton13.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton13.setText("Comment");
        commentBoton13.setBorder(null);
        commentBoton13.setFocusPainted(false);
        commentBoton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton13.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton13MouseClicked(evt);
            }
        });
        commentBoton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton13ActionPerformed(evt);
            }
        });

        commentBoton14.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton14.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton14.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton14.setText("Comment");
        commentBoton14.setBorder(null);
        commentBoton14.setFocusPainted(false);
        commentBoton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton14.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton14MouseClicked(evt);
            }
        });
        commentBoton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton14ActionPerformed(evt);
            }
        });

        commentBoton15.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton15.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton15.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton15.setText("Comment");
        commentBoton15.setBorder(null);
        commentBoton15.setFocusPainted(false);
        commentBoton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton15.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton15MouseClicked(evt);
            }
        });
        commentBoton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton15ActionPerformed(evt);
            }
        });

        commentBoton16.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton16.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton16.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton16.setText("Comment");
        commentBoton16.setBorder(null);
        commentBoton16.setFocusPainted(false);
        commentBoton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton16.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton16MouseClicked(evt);
            }
        });
        commentBoton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton16ActionPerformed(evt);
            }
        });

        commentBoton17.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton17.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton17.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton17.setText("Comment");
        commentBoton17.setBorder(null);
        commentBoton17.setFocusPainted(false);
        commentBoton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton17.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton17MouseClicked(evt);
            }
        });
        commentBoton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton17ActionPerformed(evt);
            }
        });

        commentBoton18.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton18.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton18.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton18.setText("Comment");
        commentBoton18.setBorder(null);
        commentBoton18.setFocusPainted(false);
        commentBoton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton18.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton18MouseClicked(evt);
            }
        });
        commentBoton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton18ActionPerformed(evt);
            }
        });

        commentBoton19.setBackground(new java.awt.Color(228, 147, 245));
        commentBoton19.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        commentBoton19.setForeground(new java.awt.Color(0, 0, 0));
        commentBoton19.setText("Comment");
        commentBoton19.setBorder(null);
        commentBoton19.setFocusPainted(false);
        commentBoton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commentBoton19.setPreferredSize(new java.awt.Dimension(110, 25));
        commentBoton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentBoton19MouseClicked(evt);
            }
        });
        commentBoton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentBoton19ActionPerformed(evt);
            }
        });

        vercommentBoton0.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton0.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton0.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton0.setText("View Comments");
        vercommentBoton0.setBorder(null);
        vercommentBoton0.setFocusPainted(false);
        vercommentBoton0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton0.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton0.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton0.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton0MouseClicked(evt);
            }
        });
        vercommentBoton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton0ActionPerformed(evt);
            }
        });

        vercommentBoton1.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton1.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton1.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton1.setText("View Comments");
        vercommentBoton1.setBorder(null);
        vercommentBoton1.setFocusPainted(false);
        vercommentBoton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton1.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton1.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton1.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton1MouseClicked(evt);
            }
        });
        vercommentBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton1ActionPerformed(evt);
            }
        });

        vercommentBoton2.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton2.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton2.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton2.setText("View Comments");
        vercommentBoton2.setBorder(null);
        vercommentBoton2.setFocusPainted(false);
        vercommentBoton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton2.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton2.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton2.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton2MouseClicked(evt);
            }
        });
        vercommentBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton2ActionPerformed(evt);
            }
        });

        vercommentBoton3.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton3.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton3.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton3.setText("View Comments");
        vercommentBoton3.setBorder(null);
        vercommentBoton3.setFocusPainted(false);
        vercommentBoton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton3.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton3.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton3.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton3MouseClicked(evt);
            }
        });
        vercommentBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton3ActionPerformed(evt);
            }
        });

        vercommentBoton4.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton4.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton4.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton4.setText("View Comments");
        vercommentBoton4.setBorder(null);
        vercommentBoton4.setFocusPainted(false);
        vercommentBoton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton4.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton4.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton4.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton4MouseClicked(evt);
            }
        });
        vercommentBoton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton4ActionPerformed(evt);
            }
        });

        vercommentBoton5.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton5.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton5.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton5.setText("View Comments");
        vercommentBoton5.setBorder(null);
        vercommentBoton5.setFocusPainted(false);
        vercommentBoton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton5.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton5.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton5.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton5MouseClicked(evt);
            }
        });
        vercommentBoton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton5ActionPerformed(evt);
            }
        });

        vercommentBoton6.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton6.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton6.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton6.setText("View Comments");
        vercommentBoton6.setBorder(null);
        vercommentBoton6.setFocusPainted(false);
        vercommentBoton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton6.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton6.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton6.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton6MouseClicked(evt);
            }
        });
        vercommentBoton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton6ActionPerformed(evt);
            }
        });

        vercommentBoton7.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton7.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton7.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton7.setText("View Comments");
        vercommentBoton7.setBorder(null);
        vercommentBoton7.setFocusPainted(false);
        vercommentBoton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton7.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton7.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton7.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton7MouseClicked(evt);
            }
        });
        vercommentBoton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton7ActionPerformed(evt);
            }
        });

        vercommentBoton8.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton8.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton8.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton8.setText("View Comments");
        vercommentBoton8.setBorder(null);
        vercommentBoton8.setFocusPainted(false);
        vercommentBoton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton8.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton8.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton8.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton8MouseClicked(evt);
            }
        });
        vercommentBoton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton8ActionPerformed(evt);
            }
        });

        vercommentBoton9.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton9.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton9.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton9.setText("View Comments");
        vercommentBoton9.setBorder(null);
        vercommentBoton9.setFocusPainted(false);
        vercommentBoton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton9.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton9.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton9.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton9MouseClicked(evt);
            }
        });
        vercommentBoton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton9ActionPerformed(evt);
            }
        });

        vercommentBoton10.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton10.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton10.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton10.setText("View Comments");
        vercommentBoton10.setBorder(null);
        vercommentBoton10.setFocusPainted(false);
        vercommentBoton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton10.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton10.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton10.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton10MouseClicked(evt);
            }
        });
        vercommentBoton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton10ActionPerformed(evt);
            }
        });

        vercommentBoton11.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton11.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton11.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton11.setText("View Comments");
        vercommentBoton11.setBorder(null);
        vercommentBoton11.setFocusPainted(false);
        vercommentBoton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton11.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton11.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton11.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton11MouseClicked(evt);
            }
        });
        vercommentBoton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton11ActionPerformed(evt);
            }
        });

        vercommentBoton12.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton12.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton12.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton12.setText("View Comments");
        vercommentBoton12.setBorder(null);
        vercommentBoton12.setFocusPainted(false);
        vercommentBoton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton12.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton12.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton12.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton12MouseClicked(evt);
            }
        });
        vercommentBoton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton12ActionPerformed(evt);
            }
        });

        vercommentBoton13.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton13.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton13.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton13.setText("View Comments");
        vercommentBoton13.setBorder(null);
        vercommentBoton13.setFocusPainted(false);
        vercommentBoton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton13.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton13.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton13.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton13MouseClicked(evt);
            }
        });
        vercommentBoton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton13ActionPerformed(evt);
            }
        });

        vercommentBoton14.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton14.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton14.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton14.setText("View Comments");
        vercommentBoton14.setBorder(null);
        vercommentBoton14.setFocusPainted(false);
        vercommentBoton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton14.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton14.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton14.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton14MouseClicked(evt);
            }
        });
        vercommentBoton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton14ActionPerformed(evt);
            }
        });

        vercommentBoton15.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton15.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton15.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton15.setText("View Comments");
        vercommentBoton15.setBorder(null);
        vercommentBoton15.setFocusPainted(false);
        vercommentBoton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton15.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton15.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton15.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton15MouseClicked(evt);
            }
        });
        vercommentBoton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton15ActionPerformed(evt);
            }
        });

        vercommentBoton16.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton16.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton16.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton16.setText("View Comments");
        vercommentBoton16.setBorder(null);
        vercommentBoton16.setFocusPainted(false);
        vercommentBoton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton16.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton16.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton16.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton16MouseClicked(evt);
            }
        });
        vercommentBoton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton16ActionPerformed(evt);
            }
        });

        vercommentBoton17.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton17.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton17.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton17.setText("View Comments");
        vercommentBoton17.setBorder(null);
        vercommentBoton17.setFocusPainted(false);
        vercommentBoton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton17.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton17.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton17.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton17MouseClicked(evt);
            }
        });
        vercommentBoton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton17ActionPerformed(evt);
            }
        });

        vercommentBoton18.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton18.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton18.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton18.setText("View Comments");
        vercommentBoton18.setBorder(null);
        vercommentBoton18.setFocusPainted(false);
        vercommentBoton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton18.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton18.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton18.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton18MouseClicked(evt);
            }
        });
        vercommentBoton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton18ActionPerformed(evt);
            }
        });

        vercommentBoton19.setBackground(new java.awt.Color(228, 147, 245));
        vercommentBoton19.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        vercommentBoton19.setForeground(new java.awt.Color(0, 0, 0));
        vercommentBoton19.setText("View Comments");
        vercommentBoton19.setBorder(null);
        vercommentBoton19.setFocusPainted(false);
        vercommentBoton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vercommentBoton19.setMaximumSize(new java.awt.Dimension(130, 20));
        vercommentBoton19.setMinimumSize(new java.awt.Dimension(130, 20));
        vercommentBoton19.setPreferredSize(new java.awt.Dimension(110, 25));
        vercommentBoton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vercommentBoton19MouseClicked(evt);
            }
        });
        vercommentBoton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vercommentBoton19ActionPerformed(evt);
            }
        });

        repostBoton0.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton0.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton0.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton0.setText("Repost");
        repostBoton0.setBorder(null);
        repostBoton0.setFocusPainted(false);
        repostBoton0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton0.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton0.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton0.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton0MouseClicked(evt);
            }
        });
        repostBoton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton0ActionPerformed(evt);
            }
        });

        repostBoton1.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton1.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton1.setText("Repost");
        repostBoton1.setBorder(null);
        repostBoton1.setFocusPainted(false);
        repostBoton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton1.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton1.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton1.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton1MouseClicked(evt);
            }
        });
        repostBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton1ActionPerformed(evt);
            }
        });

        repostBoton2.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton2.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton2.setText("Repost");
        repostBoton2.setBorder(null);
        repostBoton2.setFocusPainted(false);
        repostBoton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton2.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton2.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton2.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton2MouseClicked(evt);
            }
        });
        repostBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton2ActionPerformed(evt);
            }
        });

        repostBoton3.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton3.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton3.setText("Repost");
        repostBoton3.setBorder(null);
        repostBoton3.setFocusPainted(false);
        repostBoton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton3.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton3.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton3.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton3MouseClicked(evt);
            }
        });
        repostBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton3ActionPerformed(evt);
            }
        });

        repostBoton4.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton4.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton4.setText("Repost");
        repostBoton4.setBorder(null);
        repostBoton4.setFocusPainted(false);
        repostBoton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton4.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton4.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton4.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton4MouseClicked(evt);
            }
        });
        repostBoton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton4ActionPerformed(evt);
            }
        });

        repostBoton5.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton5.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton5.setText("Repost");
        repostBoton5.setBorder(null);
        repostBoton5.setFocusPainted(false);
        repostBoton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton5.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton5.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton5.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton5MouseClicked(evt);
            }
        });
        repostBoton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton5ActionPerformed(evt);
            }
        });

        repostBoton6.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton6.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton6.setText("Repost");
        repostBoton6.setBorder(null);
        repostBoton6.setFocusPainted(false);
        repostBoton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton6.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton6.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton6.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton6MouseClicked(evt);
            }
        });
        repostBoton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton6ActionPerformed(evt);
            }
        });

        repostBoton7.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton7.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton7.setText("Repost");
        repostBoton7.setBorder(null);
        repostBoton7.setFocusPainted(false);
        repostBoton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton7.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton7.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton7.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton7MouseClicked(evt);
            }
        });
        repostBoton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton7ActionPerformed(evt);
            }
        });

        repostBoton8.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton8.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton8.setText("Repost");
        repostBoton8.setBorder(null);
        repostBoton8.setFocusPainted(false);
        repostBoton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton8.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton8.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton8.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton8MouseClicked(evt);
            }
        });
        repostBoton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton8ActionPerformed(evt);
            }
        });

        repostBoton9.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton9.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton9.setText("Repost");
        repostBoton9.setBorder(null);
        repostBoton9.setFocusPainted(false);
        repostBoton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton9.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton9.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton9.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton9MouseClicked(evt);
            }
        });
        repostBoton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton9ActionPerformed(evt);
            }
        });

        repostBoton10.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton10.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton10.setText("Repost");
        repostBoton10.setBorder(null);
        repostBoton10.setFocusPainted(false);
        repostBoton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton10.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton10.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton10.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton10MouseClicked(evt);
            }
        });
        repostBoton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton10ActionPerformed(evt);
            }
        });

        repostBoton11.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton11.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton11.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton11.setText("Repost");
        repostBoton11.setBorder(null);
        repostBoton11.setFocusPainted(false);
        repostBoton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton11.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton11.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton11.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton11MouseClicked(evt);
            }
        });
        repostBoton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton11ActionPerformed(evt);
            }
        });

        repostBoton12.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton12.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton12.setText("Repost");
        repostBoton12.setBorder(null);
        repostBoton12.setFocusPainted(false);
        repostBoton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton12.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton12.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton12.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton12MouseClicked(evt);
            }
        });
        repostBoton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton12ActionPerformed(evt);
            }
        });

        repostBoton13.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton13.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton13.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton13.setText("Repost");
        repostBoton13.setBorder(null);
        repostBoton13.setFocusPainted(false);
        repostBoton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton13.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton13.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton13.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton13MouseClicked(evt);
            }
        });
        repostBoton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton13ActionPerformed(evt);
            }
        });

        repostBoton14.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton14.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton14.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton14.setText("Repost");
        repostBoton14.setBorder(null);
        repostBoton14.setFocusPainted(false);
        repostBoton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton14.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton14.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton14.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton14MouseClicked(evt);
            }
        });
        repostBoton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton14ActionPerformed(evt);
            }
        });

        repostBoton15.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton15.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton15.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton15.setText("Repost");
        repostBoton15.setBorder(null);
        repostBoton15.setFocusPainted(false);
        repostBoton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton15.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton15.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton15.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton15MouseClicked(evt);
            }
        });
        repostBoton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton15ActionPerformed(evt);
            }
        });

        repostBoton16.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton16.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton16.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton16.setText("Repost");
        repostBoton16.setBorder(null);
        repostBoton16.setFocusPainted(false);
        repostBoton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton16.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton16.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton16.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton16MouseClicked(evt);
            }
        });
        repostBoton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton16ActionPerformed(evt);
            }
        });

        repostBoton17.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton17.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton17.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton17.setText("Repost");
        repostBoton17.setBorder(null);
        repostBoton17.setFocusPainted(false);
        repostBoton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton17.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton17.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton17.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton17MouseClicked(evt);
            }
        });
        repostBoton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton17ActionPerformed(evt);
            }
        });

        repostBoton18.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton18.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton18.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton18.setText("Repost");
        repostBoton18.setBorder(null);
        repostBoton18.setFocusPainted(false);
        repostBoton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton18.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton18.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton18.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton18MouseClicked(evt);
            }
        });
        repostBoton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton18ActionPerformed(evt);
            }
        });

        repostBoton19.setBackground(new java.awt.Color(228, 147, 245));
        repostBoton19.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        repostBoton19.setForeground(new java.awt.Color(0, 0, 0));
        repostBoton19.setText("Repost");
        repostBoton19.setBorder(null);
        repostBoton19.setFocusPainted(false);
        repostBoton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repostBoton19.setMaximumSize(new java.awt.Dimension(130, 20));
        repostBoton19.setMinimumSize(new java.awt.Dimension(130, 20));
        repostBoton19.setPreferredSize(new java.awt.Dimension(130, 20));
        repostBoton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repostBoton19MouseClicked(evt);
            }
        });
        repostBoton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostBoton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout feedPanelLayout = new javax.swing.GroupLayout(feedPanel);
        feedPanel.setLayout(feedPanelLayout);
        feedPanelLayout.setHorizontalGroup(
            feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedPanelLayout.createSequentialGroup()
                .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(feedPanelLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(vercommentBoton0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(feedPanelLayout.createSequentialGroup()
                        .addGap(823, 823, 823)
                        .addComponent(commentBoton0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(feedPanelLayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(repostBoton0, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(976, Short.MAX_VALUE))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(767, 767, 767)
                    .addComponent(commentBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1032, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(777, 777, 777)
                    .addComponent(commentBoton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1022, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(787, 787, 787)
                    .addComponent(commentBoton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1012, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(797, 797, 797)
                    .addComponent(commentBoton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1002, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(797, 797, 797)
                    .addComponent(commentBoton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1002, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(807, 807, 807)
                    .addComponent(commentBoton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(992, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(807, 807, 807)
                    .addComponent(commentBoton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(992, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(817, 817, 817)
                    .addComponent(commentBoton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(982, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(817, 817, 817)
                    .addComponent(commentBoton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(982, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(827, 827, 827)
                    .addComponent(commentBoton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(972, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(827, 827, 827)
                    .addComponent(commentBoton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(972, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(837, 837, 837)
                    .addComponent(commentBoton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(962, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(837, 837, 837)
                    .addComponent(commentBoton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(962, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(837, 837, 837)
                    .addComponent(commentBoton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(962, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(847, 847, 847)
                    .addComponent(commentBoton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(952, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(847, 847, 847)
                    .addComponent(commentBoton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(952, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(847, 847, 847)
                    .addComponent(commentBoton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(952, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(857, 857, 857)
                    .addComponent(commentBoton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(942, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(867, 867, 867)
                    .addComponent(commentBoton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(932, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(565, 565, 565)
                    .addComponent(vercommentBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1234, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(575, 575, 575)
                    .addComponent(vercommentBoton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1224, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(585, 585, 585)
                    .addComponent(vercommentBoton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1214, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(595, 595, 595)
                    .addComponent(vercommentBoton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1204, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(605, 605, 605)
                    .addComponent(vercommentBoton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1194, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(615, 615, 615)
                    .addComponent(vercommentBoton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1184, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(615, 615, 615)
                    .addComponent(vercommentBoton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1184, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(625, 625, 625)
                    .addComponent(vercommentBoton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1174, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(625, 625, 625)
                    .addComponent(vercommentBoton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1174, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(635, 635, 635)
                    .addComponent(vercommentBoton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1164, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(635, 635, 635)
                    .addComponent(vercommentBoton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1164, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(645, 645, 645)
                    .addComponent(vercommentBoton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1154, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(645, 645, 645)
                    .addComponent(vercommentBoton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1154, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(655, 655, 655)
                    .addComponent(vercommentBoton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1144, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(655, 655, 655)
                    .addComponent(vercommentBoton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1144, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(665, 665, 665)
                    .addComponent(vercommentBoton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1134, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(665, 665, 665)
                    .addComponent(vercommentBoton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1134, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(675, 675, 675)
                    .addComponent(vercommentBoton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1124, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(675, 675, 675)
                    .addComponent(vercommentBoton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1124, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(246, 246, 246)
                    .addComponent(repostBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1588, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(256, 256, 256)
                    .addComponent(repostBoton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1578, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(256, 256, 256)
                    .addComponent(repostBoton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1578, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(266, 266, 266)
                    .addComponent(repostBoton4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1568, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(266, 266, 266)
                    .addComponent(repostBoton5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1568, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(266, 266, 266)
                    .addComponent(repostBoton6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1568, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(276, 276, 276)
                    .addComponent(repostBoton7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1558, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(276, 276, 276)
                    .addComponent(repostBoton8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1558, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(276, 276, 276)
                    .addComponent(repostBoton9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1558, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(286, 286, 286)
                    .addComponent(repostBoton10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1548, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(286, 286, 286)
                    .addComponent(repostBoton11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1548, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(286, 286, 286)
                    .addComponent(repostBoton12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1548, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(286, 286, 286)
                    .addComponent(repostBoton13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1548, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(286, 286, 286)
                    .addComponent(repostBoton14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1548, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(296, 296, 296)
                    .addComponent(repostBoton15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1538, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(296, 296, 296)
                    .addComponent(repostBoton16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1538, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(296, 296, 296)
                    .addComponent(repostBoton17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1538, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(296, 296, 296)
                    .addComponent(repostBoton18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1538, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(296, 296, 296)
                    .addComponent(repostBoton19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1538, Short.MAX_VALUE)))
        );
        feedPanelLayout.setVerticalGroup(
            feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedPanelLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(vercommentBoton0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(repostBoton0, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(commentBoton0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(430, Short.MAX_VALUE))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(379, 379, 379)
                    .addComponent(commentBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(416, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(389, 389, 389)
                    .addComponent(commentBoton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(406, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(399, 399, 399)
                    .addComponent(commentBoton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(396, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(404, Short.MAX_VALUE)
                    .addComponent(commentBoton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(391, 391, 391)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(404, Short.MAX_VALUE)
                    .addComponent(commentBoton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(391, 391, 391)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(414, Short.MAX_VALUE)
                    .addComponent(commentBoton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(381, 381, 381)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(414, Short.MAX_VALUE)
                    .addComponent(commentBoton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(381, 381, 381)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(424, Short.MAX_VALUE)
                    .addComponent(commentBoton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(371, 371, 371)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(424, Short.MAX_VALUE)
                    .addComponent(commentBoton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(371, 371, 371)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(434, Short.MAX_VALUE)
                    .addComponent(commentBoton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(361, 361, 361)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(434, Short.MAX_VALUE)
                    .addComponent(commentBoton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(361, 361, 361)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(444, Short.MAX_VALUE)
                    .addComponent(commentBoton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(351, 351, 351)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(444, Short.MAX_VALUE)
                    .addComponent(commentBoton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(351, 351, 351)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(444, Short.MAX_VALUE)
                    .addComponent(commentBoton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(351, 351, 351)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(454, Short.MAX_VALUE)
                    .addComponent(commentBoton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(341, 341, 341)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(454, Short.MAX_VALUE)
                    .addComponent(commentBoton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(341, 341, 341)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(454, Short.MAX_VALUE)
                    .addComponent(commentBoton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(341, 341, 341)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(464, Short.MAX_VALUE)
                    .addComponent(commentBoton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(331, 331, 331)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(474, Short.MAX_VALUE)
                    .addComponent(commentBoton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(321, 321, 321)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(375, 375, 375)
                    .addComponent(vercommentBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(420, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(385, 385, 385)
                    .addComponent(vercommentBoton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(410, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(395, 395, 395)
                    .addComponent(vercommentBoton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(400, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(400, Short.MAX_VALUE)
                    .addComponent(vercommentBoton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(395, 395, 395)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(410, Short.MAX_VALUE)
                    .addComponent(vercommentBoton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(385, 385, 385)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(420, Short.MAX_VALUE)
                    .addComponent(vercommentBoton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(375, 375, 375)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(420, Short.MAX_VALUE)
                    .addComponent(vercommentBoton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(375, 375, 375)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(430, Short.MAX_VALUE)
                    .addComponent(vercommentBoton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(365, 365, 365)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(430, Short.MAX_VALUE)
                    .addComponent(vercommentBoton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(365, 365, 365)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(440, Short.MAX_VALUE)
                    .addComponent(vercommentBoton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(355, 355, 355)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(440, Short.MAX_VALUE)
                    .addComponent(vercommentBoton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(355, 355, 355)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(450, Short.MAX_VALUE)
                    .addComponent(vercommentBoton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(345, 345, 345)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(450, Short.MAX_VALUE)
                    .addComponent(vercommentBoton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(345, 345, 345)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(460, Short.MAX_VALUE)
                    .addComponent(vercommentBoton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(335, 335, 335)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(460, Short.MAX_VALUE)
                    .addComponent(vercommentBoton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(335, 335, 335)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(470, Short.MAX_VALUE)
                    .addComponent(vercommentBoton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(325, 325, 325)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(470, Short.MAX_VALUE)
                    .addComponent(vercommentBoton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(325, 325, 325)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(480, Short.MAX_VALUE)
                    .addComponent(vercommentBoton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(315, 315, 315)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedPanelLayout.createSequentialGroup()
                    .addContainerGap(480, Short.MAX_VALUE)
                    .addComponent(vercommentBoton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(315, 315, 315)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(323, 323, 323)
                    .addComponent(repostBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(464, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(333, 333, 333)
                    .addComponent(repostBoton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(333, 333, 333)
                    .addComponent(repostBoton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(343, 343, 343)
                    .addComponent(repostBoton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(444, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(343, 343, 343)
                    .addComponent(repostBoton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(444, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(343, 343, 343)
                    .addComponent(repostBoton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(444, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(353, 353, 353)
                    .addComponent(repostBoton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(434, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(353, 353, 353)
                    .addComponent(repostBoton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(434, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(353, 353, 353)
                    .addComponent(repostBoton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(434, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(363, 363, 363)
                    .addComponent(repostBoton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(424, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(363, 363, 363)
                    .addComponent(repostBoton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(424, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(363, 363, 363)
                    .addComponent(repostBoton12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(424, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(363, 363, 363)
                    .addComponent(repostBoton13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(424, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(363, 363, 363)
                    .addComponent(repostBoton14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(424, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(373, 373, 373)
                    .addComponent(repostBoton15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(414, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(373, 373, 373)
                    .addComponent(repostBoton16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(414, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(373, 373, 373)
                    .addComponent(repostBoton17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(414, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(373, 373, 373)
                    .addComponent(repostBoton18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(414, Short.MAX_VALUE)))
            .addGroup(feedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(feedPanelLayout.createSequentialGroup()
                    .addGap(373, 373, 373)
                    .addComponent(repostBoton19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(414, Short.MAX_VALUE)))
        );

        scrollFeed.setViewportView(feedPanel);

        mainContentPanel.add(scrollFeed, "feedPanel");

        searchPanel.setBackground(new java.awt.Color(20, 20, 20));

        searchBar.setBackground(new java.awt.Color(64, 64, 64));
        searchBar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        searchBar.setForeground(new java.awt.Color(255, 255, 255));
        searchBar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchBar.setAutoscrolls(false);
        searchBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        SIboton1.setBackground(new java.awt.Color(228, 147, 245));
        SIboton1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        SIboton1.setForeground(new java.awt.Color(0, 0, 0));
        SIboton1.setText("Buscar");
        SIboton1.setBorder(null);
        SIboton1.setFocusPainted(false);
        SIboton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SIboton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SIboton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SIboton1MouseExited(evt);
            }
        });
        SIboton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIboton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(20, 20, 20));

        profileSearch0.setBackground(new java.awt.Color(40, 40, 40));
        profileSearch0.setPreferredSize(new java.awt.Dimension(0, 59));
        profileSearch0.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBoton0.setBackground(new java.awt.Color(228, 147, 245));
        searchBoton0.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        searchBoton0.setForeground(new java.awt.Color(0, 0, 0));
        searchBoton0.setText("Ir a Perfil");
        searchBoton0.setBorder(null);
        searchBoton0.setFocusPainted(false);
        searchBoton0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton0MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoton0MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoton0MouseExited(evt);
            }
        });
        searchBoton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoton0ActionPerformed(evt);
            }
        });
        profileSearch0.add(searchBoton0, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 86, 30));

        searchNombre0.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        searchNombre0.setForeground(new java.awt.Color(255, 255, 255));
        searchNombre0.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchNombre0.setText("nombre");
        profileSearch0.add(searchNombre0, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 390, -1));
        profileSearch0.add(searchFoto0, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 50, 50));

        searchEmail0.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchEmail0.setForeground(new java.awt.Color(228, 147, 245));
        searchEmail0.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchEmail0.setText("nombre");
        profileSearch0.add(searchEmail0, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 236, -1));

        profileSearch1.setBackground(new java.awt.Color(40, 40, 40));
        profileSearch1.setPreferredSize(new java.awt.Dimension(0, 59));
        profileSearch1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBoton2.setBackground(new java.awt.Color(228, 147, 245));
        searchBoton2.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        searchBoton2.setForeground(new java.awt.Color(0, 0, 0));
        searchBoton2.setText("Ir a Perfil");
        searchBoton2.setBorder(null);
        searchBoton2.setFocusPainted(false);
        searchBoton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoton2MouseExited(evt);
            }
        });
        searchBoton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoton2ActionPerformed(evt);
            }
        });
        profileSearch1.add(searchBoton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 86, 30));

        searchNombre1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        searchNombre1.setForeground(new java.awt.Color(255, 255, 255));
        searchNombre1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchNombre1.setText("nombre");
        profileSearch1.add(searchNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 390, -1));
        profileSearch1.add(searchFoto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 50, 50));

        searchEmail1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchEmail1.setForeground(new java.awt.Color(228, 147, 245));
        searchEmail1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchEmail1.setText("nombre");
        profileSearch1.add(searchEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 236, -1));

        profileSearch2.setBackground(new java.awt.Color(40, 40, 40));
        profileSearch2.setPreferredSize(new java.awt.Dimension(0, 59));
        profileSearch2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBoton3.setBackground(new java.awt.Color(228, 147, 245));
        searchBoton3.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        searchBoton3.setForeground(new java.awt.Color(0, 0, 0));
        searchBoton3.setText("Ir a Perfil");
        searchBoton3.setBorder(null);
        searchBoton3.setFocusPainted(false);
        searchBoton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoton3MouseExited(evt);
            }
        });
        searchBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoton3ActionPerformed(evt);
            }
        });
        profileSearch2.add(searchBoton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 86, 30));

        searchNombre2.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        searchNombre2.setForeground(new java.awt.Color(255, 255, 255));
        searchNombre2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchNombre2.setText("nombre");
        profileSearch2.add(searchNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 390, -1));
        profileSearch2.add(searchFoto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 50, 50));

        searchEmail2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchEmail2.setForeground(new java.awt.Color(228, 147, 245));
        searchEmail2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchEmail2.setText("nombre");
        profileSearch2.add(searchEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 236, -1));

        profileSearch3.setBackground(new java.awt.Color(40, 40, 40));
        profileSearch3.setPreferredSize(new java.awt.Dimension(0, 59));
        profileSearch3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBoton4.setBackground(new java.awt.Color(228, 147, 245));
        searchBoton4.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        searchBoton4.setForeground(new java.awt.Color(0, 0, 0));
        searchBoton4.setText("Ir a Perfil");
        searchBoton4.setBorder(null);
        searchBoton4.setFocusPainted(false);
        searchBoton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoton4MouseExited(evt);
            }
        });
        searchBoton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoton4ActionPerformed(evt);
            }
        });
        profileSearch3.add(searchBoton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 86, 30));

        searchNombre3.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        searchNombre3.setForeground(new java.awt.Color(255, 255, 255));
        searchNombre3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchNombre3.setText("nombre");
        profileSearch3.add(searchNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 380, -1));
        profileSearch3.add(searchFoto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 50, 50));

        searchEmail3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchEmail3.setForeground(new java.awt.Color(228, 147, 245));
        searchEmail3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchEmail3.setText("nombre");
        profileSearch3.add(searchEmail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 236, -1));

        profileSearch4.setBackground(new java.awt.Color(40, 40, 40));
        profileSearch4.setPreferredSize(new java.awt.Dimension(0, 59));
        profileSearch4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBoton5.setBackground(new java.awt.Color(228, 147, 245));
        searchBoton5.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        searchBoton5.setForeground(new java.awt.Color(0, 0, 0));
        searchBoton5.setText("Ir a Perfil");
        searchBoton5.setBorder(null);
        searchBoton5.setFocusPainted(false);
        searchBoton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoton5MouseExited(evt);
            }
        });
        searchBoton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoton5ActionPerformed(evt);
            }
        });
        profileSearch4.add(searchBoton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 86, 30));

        searchNombre4.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        searchNombre4.setForeground(new java.awt.Color(255, 255, 255));
        searchNombre4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchNombre4.setText("nombre");
        profileSearch4.add(searchNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 390, -1));
        profileSearch4.add(searchFoto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 50, 50));

        searchEmail4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchEmail4.setForeground(new java.awt.Color(228, 147, 245));
        searchEmail4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchEmail4.setText("nombre");
        profileSearch4.add(searchEmail4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 236, -1));

        profileSearch5.setBackground(new java.awt.Color(40, 40, 40));
        profileSearch5.setPreferredSize(new java.awt.Dimension(0, 59));
        profileSearch5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBoton6.setBackground(new java.awt.Color(228, 147, 245));
        searchBoton6.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        searchBoton6.setForeground(new java.awt.Color(0, 0, 0));
        searchBoton6.setText("Ir a Perfil");
        searchBoton6.setBorder(null);
        searchBoton6.setFocusPainted(false);
        searchBoton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoton6MouseExited(evt);
            }
        });
        searchBoton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoton6ActionPerformed(evt);
            }
        });
        profileSearch5.add(searchBoton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 86, 30));

        searchNombre5.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        searchNombre5.setForeground(new java.awt.Color(255, 255, 255));
        searchNombre5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchNombre5.setText("nombre");
        profileSearch5.add(searchNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 380, -1));
        profileSearch5.add(searchFoto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 50, 50));

        searchEmail5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchEmail5.setForeground(new java.awt.Color(228, 147, 245));
        searchEmail5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchEmail5.setText("nombre");
        profileSearch5.add(searchEmail5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 236, -1));

        profileSearch6.setBackground(new java.awt.Color(40, 40, 40));
        profileSearch6.setPreferredSize(new java.awt.Dimension(0, 59));
        profileSearch6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBoton7.setBackground(new java.awt.Color(228, 147, 245));
        searchBoton7.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        searchBoton7.setForeground(new java.awt.Color(0, 0, 0));
        searchBoton7.setText("Ir a Perfil");
        searchBoton7.setBorder(null);
        searchBoton7.setFocusPainted(false);
        searchBoton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoton7MouseExited(evt);
            }
        });
        searchBoton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoton7ActionPerformed(evt);
            }
        });
        profileSearch6.add(searchBoton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 86, 30));

        searchNombre6.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        searchNombre6.setForeground(new java.awt.Color(255, 255, 255));
        searchNombre6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchNombre6.setText("nombre");
        profileSearch6.add(searchNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 390, -1));
        profileSearch6.add(searchFoto6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 50, 50));

        searchEmail6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchEmail6.setForeground(new java.awt.Color(228, 147, 245));
        searchEmail6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchEmail6.setText("nombre");
        profileSearch6.add(searchEmail6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 236, -1));

        profileSearch7.setBackground(new java.awt.Color(40, 40, 40));
        profileSearch7.setPreferredSize(new java.awt.Dimension(0, 59));
        profileSearch7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBoton8.setBackground(new java.awt.Color(228, 147, 245));
        searchBoton8.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        searchBoton8.setForeground(new java.awt.Color(0, 0, 0));
        searchBoton8.setText("Ir a Perfil");
        searchBoton8.setBorder(null);
        searchBoton8.setFocusPainted(false);
        searchBoton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoton8MouseExited(evt);
            }
        });
        searchBoton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoton8ActionPerformed(evt);
            }
        });
        profileSearch7.add(searchBoton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 86, 30));

        searchNombre7.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        searchNombre7.setForeground(new java.awt.Color(255, 255, 255));
        searchNombre7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchNombre7.setText("nombre");
        profileSearch7.add(searchNombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 380, -1));
        profileSearch7.add(searchFoto7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 50, 50));

        searchEmail7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchEmail7.setForeground(new java.awt.Color(228, 147, 245));
        searchEmail7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchEmail7.setText("nombre");
        profileSearch7.add(searchEmail7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 236, -1));

        profileSearch8.setBackground(new java.awt.Color(40, 40, 40));
        profileSearch8.setPreferredSize(new java.awt.Dimension(0, 59));
        profileSearch8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBoton9.setBackground(new java.awt.Color(228, 147, 245));
        searchBoton9.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        searchBoton9.setForeground(new java.awt.Color(0, 0, 0));
        searchBoton9.setText("Ir a Perfil");
        searchBoton9.setBorder(null);
        searchBoton9.setFocusPainted(false);
        searchBoton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoton9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoton9MouseExited(evt);
            }
        });
        searchBoton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoton9ActionPerformed(evt);
            }
        });
        profileSearch8.add(searchBoton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 86, 30));

        searchNombre8.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        searchNombre8.setForeground(new java.awt.Color(255, 255, 255));
        searchNombre8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchNombre8.setText("nombre");
        profileSearch8.add(searchNombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 380, -1));
        profileSearch8.add(searchFoto8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 50, 50));

        searchEmail8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        searchEmail8.setForeground(new java.awt.Color(228, 147, 245));
        searchEmail8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        searchEmail8.setText("nombre");
        profileSearch8.add(searchEmail8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 236, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileSearch0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileSearch1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileSearch2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileSearch3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileSearch4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileSearch5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileSearch6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileSearch7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileSearch8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(profileSearch0, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileSearch6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileSearch7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileSearch8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SIboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SIboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainContentPanel.add(searchPanel, "searchPanel");

        panelProfile.setBackground(new java.awt.Color(20, 20, 20));

        jPanel9.setBackground(new java.awt.Color(20, 20, 20));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fotoProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fotoProfileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jPanel6.setBackground(new java.awt.Color(204, 0, 255));

        fotoBanner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fotoBannerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoBanner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fotoBanner, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(228, 147, 245));
        jLabel7.setText("POSTS:");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, 31));

        jPanel8.setBackground(new java.awt.Color(20, 20, 20));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Programando una Waifu");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 6, 354, 43));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(228, 147, 245));
        jLabel6.setText("@JosueEduardoYElOtro");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 55, 231, 43));

        jScrollPane3.setBorder(null);

        jTextArea2.setBackground(new java.awt.Color(40, 40, 40));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(204, 204, 204));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("kimi no toriko ni natte, shimaeba kitto\nkono natsu wa jyujitsu, suru no motto\nuwasa no doriimingaaru ga wasurenaide\n\ndemo kimochi wo tsutaete shimaeba itsuka\nkono yume wa samete shimaedarou na\naoi kage ga, yurureru machikato\n\nkimi no to kimi no tori ko ni natte shimaeba kitto\nkono atsu wa jyujitsu suru no motto\nuwasa no doriimingaaru, ga wasurenaide\n");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(null);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 159, 550, 178));

        newBio1.setBackground(new java.awt.Color(228, 147, 245));
        newBio1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        newBio1.setForeground(new java.awt.Color(0, 0, 0));
        newBio1.setText("Send Request");
        newBio1.setBorder(null);
        newBio1.setFocusPainted(false);
        newBio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBio1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBio1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newBio1MouseExited(evt);
            }
        });
        newBio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBio1ActionPerformed(evt);
            }
        });
        jPanel8.add(newBio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 130, 30));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(228, 147, 245));
        jLabel8.setText("BIO:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 116, 43, 31));

        jButton2.setBackground(new java.awt.Color(228, 147, 245));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Editar Foto");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel8.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 100, -1));

        jButton1.setBackground(new java.awt.Color(228, 147, 245));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Editar Portada");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 150, 30));

        newBio.setBackground(new java.awt.Color(228, 147, 245));
        newBio.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        newBio.setForeground(new java.awt.Color(0, 0, 0));
        newBio.setText("Update");
        newBio.setBorder(null);
        newBio.setFocusPainted(false);
        newBio.setPreferredSize(new java.awt.Dimension(45, 20));
        newBio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newBioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newBioMouseExited(evt);
            }
        });
        newBio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBioActionPerformed(evt);
            }
        });
        jPanel8.add(newBio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 90, 30));

        jPanel9.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 570, 350));

        ConfigurarCuentaButton.setBackground(new java.awt.Color(228, 147, 245));
        ConfigurarCuentaButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        ConfigurarCuentaButton.setForeground(new java.awt.Color(0, 0, 0));
        ConfigurarCuentaButton.setText("Amigos de Amigos");
        ConfigurarCuentaButton.setBorder(null);
        ConfigurarCuentaButton.setFocusPainted(false);
        ConfigurarCuentaButton.setPreferredSize(new java.awt.Dimension(45, 20));
        ConfigurarCuentaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfigurarCuentaButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ConfigurarCuentaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConfigurarCuentaButtonMouseExited(evt);
            }
        });
        ConfigurarCuentaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigurarCuentaButtonActionPerformed(evt);
            }
        });
        jPanel9.add(ConfigurarCuentaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, 160, 30));

        posts1.setBackground(new java.awt.Color(228, 147, 245));
        posts1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        posts1.setForeground(new java.awt.Color(0, 0, 0));
        posts1.setText("Posts");
        posts1.setBorder(null);
        posts1.setFocusPainted(false);
        posts1.setPreferredSize(new java.awt.Dimension(45, 20));
        posts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posts1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                posts1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                posts1MouseExited(evt);
            }
        });
        posts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posts1ActionPerformed(evt);
            }
        });
        jPanel9.add(posts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 80, 30));

        reposts2.setBackground(new java.awt.Color(228, 147, 245));
        reposts2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        reposts2.setForeground(new java.awt.Color(0, 0, 0));
        reposts2.setText("Reposts");
        reposts2.setBorder(null);
        reposts2.setFocusPainted(false);
        reposts2.setPreferredSize(new java.awt.Dimension(45, 20));
        reposts2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reposts2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reposts2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reposts2MouseExited(evt);
            }
        });
        reposts2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reposts2ActionPerformed(evt);
            }
        });
        jPanel9.add(reposts2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 80, 30));

        javax.swing.GroupLayout panelProfileLayout = new javax.swing.GroupLayout(panelProfile);
        panelProfile.setLayout(panelProfileLayout);
        panelProfileLayout.setHorizontalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelProfileLayout.setVerticalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        profileView.setViewportView(panelProfile);

        mainContentPanel.add(profileView, "profileView");

        newFollowScroll.setBorder(null);

        newFollowPanel.setBackground(new java.awt.Color(20, 20, 20));
        newFollowPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newFollowPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout newFollowPanelLayout = new javax.swing.GroupLayout(newFollowPanel);
        newFollowPanel.setLayout(newFollowPanelLayout);
        newFollowPanelLayout.setHorizontalGroup(
            newFollowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        newFollowPanelLayout.setVerticalGroup(
            newFollowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );

        newFollowScroll.setViewportView(newFollowPanel);

        newTweet3.setBackground(new java.awt.Color(228, 147, 245));
        newTweet3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        newTweet3.setForeground(new java.awt.Color(0, 0, 0));
        newTweet3.setText("Aceptar Requests");
        newTweet3.setBorder(null);
        newTweet3.setFocusPainted(false);
        newTweet3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newTweet3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newTweet3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newTweet3MouseExited(evt);
            }
        });
        newTweet3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTweet3ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(228, 147, 245));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Follow Requests:");

        javax.swing.GroupLayout HomePageLayout = new javax.swing.GroupLayout(HomePage);
        HomePage.setLayout(HomePageLayout);
        HomePageLayout.setHorizontalGroup(
            HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePageLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newFollowScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newTweet3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        HomePageLayout.setVerticalGroup(
            HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newFollowScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newTweet3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        MainPanel.add(HomePage, "HomePage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MainPanel.getAccessibleContext().setAccessibleName("MainPanel");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void fetchPosts() {
        posts = db.getCollection("Posts", Posts.class);
        ListPosts = posts.find().into(new ArrayList<>());
        posties = (ArrayList<Posts>) ListPosts;
        
        userss = db.getCollection("Users", Users.class);
        
        comms = db.getCollection("Comments", Comments.class);
        generate2HRPosts();
        ListUsus = userss.find().into(new ArrayList<>());

        commsies = comms.find().into(new ArrayList<>());
        commenties = (ArrayList<Comments>) commsies;
        usuariosss = (ArrayList<Users>) ListUsus;
        
    }
    private void SUemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUemailActionPerformed

    private void SUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUnameActionPerformed

    private void SUsurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUsurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUsurActionPerformed

    private void SignUpBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpBotonActionPerformed

    }//GEN-LAST:event_SignUpBotonActionPerformed

    public static String byteToHex(String pass) throws NoSuchAlgorithmException {
        return byteToHex(getHash(pass));
    }

    public void initiateSearchArrayList() {
        /*for (int i = 0; i < 9; i++) {
            System.out.println("searchItem s" + i + " = new searchItem(profileSearch" + i + ", searchFoto" + i + ", searchNombre" + i + ", searchEmail" + i + ", searchBoton" + (i + 1) + ");");
            System.out.println("searchItems.add(s" + i + ");");
            System.out.println("s" + i + ".Disable();");
        }*/

        searchItem s0 = new searchItem(profileSearch0, searchFoto0, searchNombre0, searchEmail0, searchBoton0);
        searchItems.add(s0);
        s0.Disable();
        searchItem s1 = new searchItem(profileSearch1, searchFoto1, searchNombre1, searchEmail1, searchBoton2);
        searchItems.add(s1);
        s1.Disable();
        searchItem s2 = new searchItem(profileSearch2, searchFoto2, searchNombre2, searchEmail2, searchBoton3);
        searchItems.add(s2);
        s2.Disable();
        searchItem s3 = new searchItem(profileSearch3, searchFoto3, searchNombre3, searchEmail3, searchBoton4);
        searchItems.add(s3);
        s3.Disable();
        searchItem s4 = new searchItem(profileSearch4, searchFoto4, searchNombre4, searchEmail4, searchBoton5);
        searchItems.add(s4);
        s4.Disable();
        searchItem s5 = new searchItem(profileSearch5, searchFoto5, searchNombre5, searchEmail5, searchBoton6);
        searchItems.add(s5);
        s5.Disable();
        searchItem s6 = new searchItem(profileSearch6, searchFoto6, searchNombre6, searchEmail6, searchBoton7);
        searchItems.add(s6);
        s6.Disable();
        searchItem s7 = new searchItem(profileSearch7, searchFoto7, searchNombre7, searchEmail7, searchBoton8);
        searchItems.add(s7);
        s7.Disable();
        searchItem s8 = new searchItem(profileSearch8, searchFoto8, searchNombre8, searchEmail8, searchBoton9);
        searchItems.add(s8);
        s8.Disable();

        /*for (int i = 0; i < 20; i++) {
            System.out.println("commentBotonz.add(commentBoton" + i + ");");
            System.out.println("verCommentBotonz.add(vercommentBoton" + i + ");");
            System.out.println("repostBotonz.add(repostBoton" + i + ");");
        }*/
        commentBotonz.add(commentBoton0);
        verCommentBotonz.add(vercommentBoton0);
        repostBotonz.add(repostBoton0);
        commentBotonz.add(commentBoton1);
        verCommentBotonz.add(vercommentBoton1);
        repostBotonz.add(repostBoton1);
        commentBotonz.add(commentBoton2);
        verCommentBotonz.add(vercommentBoton2);
        repostBotonz.add(repostBoton2);
        commentBotonz.add(commentBoton3);
        verCommentBotonz.add(vercommentBoton3);
        repostBotonz.add(repostBoton3);
        commentBotonz.add(commentBoton4);
        verCommentBotonz.add(vercommentBoton4);
        repostBotonz.add(repostBoton4);
        commentBotonz.add(commentBoton5);
        verCommentBotonz.add(vercommentBoton5);
        repostBotonz.add(repostBoton5);
        commentBotonz.add(commentBoton6);
        verCommentBotonz.add(vercommentBoton6);
        repostBotonz.add(repostBoton6);
        commentBotonz.add(commentBoton7);
        verCommentBotonz.add(vercommentBoton7);
        repostBotonz.add(repostBoton7);
        commentBotonz.add(commentBoton8);
        verCommentBotonz.add(vercommentBoton8);
        repostBotonz.add(repostBoton8);
        commentBotonz.add(commentBoton9);
        verCommentBotonz.add(vercommentBoton9);
        repostBotonz.add(repostBoton9);
        commentBotonz.add(commentBoton10);
        verCommentBotonz.add(vercommentBoton10);
        repostBotonz.add(repostBoton10);
        commentBotonz.add(commentBoton11);
        verCommentBotonz.add(vercommentBoton11);
        repostBotonz.add(repostBoton11);
        commentBotonz.add(commentBoton12);
        verCommentBotonz.add(vercommentBoton12);
        repostBotonz.add(repostBoton12);
        commentBotonz.add(commentBoton13);
        verCommentBotonz.add(vercommentBoton13);
        repostBotonz.add(repostBoton13);
        commentBotonz.add(commentBoton14);
        verCommentBotonz.add(vercommentBoton14);
        repostBotonz.add(repostBoton14);
        commentBotonz.add(commentBoton15);
        verCommentBotonz.add(vercommentBoton15);
        repostBotonz.add(repostBoton15);
        commentBotonz.add(commentBoton16);
        verCommentBotonz.add(vercommentBoton16);
        repostBotonz.add(repostBoton16);
        commentBotonz.add(commentBoton17);
        verCommentBotonz.add(vercommentBoton17);
        repostBotonz.add(repostBoton17);
        commentBotonz.add(commentBoton18);
        verCommentBotonz.add(vercommentBoton18);
        repostBotonz.add(repostBoton18);
        commentBotonz.add(commentBoton19);
        verCommentBotonz.add(vercommentBoton19);
        repostBotonz.add(repostBoton19);
    }

    public static String byteToHex(byte[] hash) {

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(255 & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        // System.out.println(hexString);
        return hexString.toString();
    }

    private static byte[] hash;

    public static byte[] getHash(String passie) throws NoSuchAlgorithmException {
        MessageDigest mD = MessageDigest.getInstance("SHA-256");
        return hash = mD.digest(passie.getBytes(StandardCharsets.UTF_8));

    }

    public void addUser(String apellidos, String birthDate, String email, String nombres, String pass) throws NoSuchAlgorithmException {

        ArrayList<String> friends = new ArrayList();
        ArrayList<String> requests = new ArrayList();
        String bio = "";
        Users user = new Users(apellidos, bio, birthDate, email, friends, nombres, byteToHex(pass), requests);
        usuariosss.add(user);
        userss.insertOne(user);

    }
    private void SignUpBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpBotonMouseClicked
        if (SUemail.getText().equals("") || SUpass.getText().equals("") || SUname.getText().equals("") || SUsur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Porfavor rellenar todos los campos.");
        } else if (SUbd.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Porfavor seleccione una fecha apropiada en el DateChooser.");
        } else {
            //AQUI SE AGARRAN LOS CAMPOS Y SE INGRESAN A LA DB
            boolean flag = false;
            String email = SUemail.getText();

            String names = SUname.getText();
            String lasts = SUsur.getText();
            String passie = new String(SUpass.getPassword());
            Date date = SUbd.getDate();
            String date2 = DateFormat.getDateInstance().format(date);
            String bio = "";

            Random rd = new Random();

            String code = "";
            for (int i = 0; i < 6; i++) {
                code += String.valueOf(rd.nextInt(26) + 65);
            }
            String newCode = "";
            System.out.println(code);
            for (int i = 0; i < code.length(); i += 2) {
                String thingy = String.valueOf(code.charAt(i));
                thingy += code.charAt(i + 1);
                int codie = Integer.parseInt(thingy);

                newCode += (char) codie;

            }

            mandarCorreo(email, newCode);

            String verification = (JOptionPane.showInputDialog("Se le ha enviado el codigo de verificacion!\nPor favor ingresarlo para poder registrarse!"));

            while (verification.equals(newCode) == false) {
                verification = (JOptionPane.showInputDialog("El codigo es incorrecto!\nPor favor ingresarlo correctamente para poder registrarse!"));
            }
            try {
                addUser(lasts, date2, email, names, passie);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            CardLayout card = (CardLayout) MainPanel.getLayout();
            card.show(MainPanel, "SignInPanel");
            SUemail.setText("");
            SUpass.setText("");
            SUname.setText("");
            SUsur.setText("");
            SUbd.setDate(date);
            JOptionPane.showMessageDialog(null, "Sign Up exitoso. ;)");
            //   generatePosts();

        }
    }//GEN-LAST:event_SignUpBotonMouseClicked
    public static void mandarCorreo(String receptor, String desc) {
        // El correo gmail de envío
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session sesion = Session.getDefaultInstance(props);
        String correoEnvia = "eaguilaortiz0403@gmail.com";
        String contrasena = "fehkoxwfhvypflok";

        String asunto = "Verificacion de Correo";
        String mensaje = "Su codigo de verificacion es: \n" + desc + "\n Insertelo en su programa para validar su correo!";
        try {
            MimeMessage mail = new MimeMessage(sesion);

            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);

            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia, contrasena);

            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private void SUpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUpassActionPerformed

    private void SIemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SIemailActionPerformed

    private void SIbotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIbotonMouseClicked
        if (SIemail.getText().equals("") || SIpass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Porfavor rellenar todos los campos.");
        } else if (SIemail.getText().equals("admin@gmail.com")) {
            currentuser = "admin@gmail.com";
            generateFollowRequests();
            updateperfil();
            setPortrait();
            setPFP2();
            CardLayout card = (CardLayout) MainPanel.getLayout();
            card.show(MainPanel, "HomePage");
            refresh();
            SIemail.setText("");
            SIpass.setText("");
            /*   try {
                    uploadPropic();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            generate2HRPosts();
        } else {

            //AQUI SE VALIDA Q ESTE CORRECTO
            if (validarUser(SIemail.getText(), new String(SIpass.getPassword()))) {
                generateFollowRequests();
                updateperfil();
                setPortrait();
                setPFP2();
                CardLayout card = (CardLayout) MainPanel.getLayout();
                card.show(MainPanel, "HomePage");
                refresh();
                SIemail.setText("");
                SIpass.setText("");
                /*   try {
                    uploadPropic();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                generate2HRPosts();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña invalida.");
            }

        }

    }//GEN-LAST:event_SIbotonMouseClicked

    public void updateperfil() {
        jLabel5.setText(currentuser);
        Bson projectionFields = Projections.fields(
                Projections.include("bnombres", "capellidos"),
                Projections.excludeId());
        Document doc = users.find(eq("aemail", currentuser))
                .projection(projectionFields)
                .first();
        if (doc == null) {
            System.out.println("No results found.");
        } else {

            int count = 0;
            String test = doc.toJson();
            String nombres = "";
            String apellidos = "";
            StringTokenizer tokenizer = new StringTokenizer(test, ",");
            while (tokenizer.hasMoreElements()) {
                if (count == 0) {
                    nombres = tokenizer.nextToken();
                    count++;
                } else {
                    apellidos = tokenizer.nextToken();
                }
            }

            tokenizer = new StringTokenizer(nombres, ":");
            tokenizer.nextToken();
            String nombres2 = tokenizer.nextToken();
            tokenizer = new StringTokenizer(apellidos, ":");
            tokenizer.nextToken();
            String apellidos2 = tokenizer.nextToken();
            String nombres3 = "";
            String apellidos3 = "";
            for (int i = 2; i < nombres2.length() - 1; i++) {
                nombres3 += nombres2.charAt(i);
            }
            for (int i = 2; i < apellidos2.length() - 2; i++) {
                apellidos3 += apellidos2.charAt(i);
            }
            jLabel6.setText(nombres3 + " " + apellidos3);
            setBio();

        }
    }

    public void setPFP2() {
        Bson projectionFields = Projections.fields(
                Projections.include("iadrPropic"),
                Projections.excludeId());
        Document doc = users.find(eq("aemail", currentuser))
                .projection(projectionFields)
                .first();
        if (doc == null) {
            System.out.println("No results found.");
        } else {
            int count = 0;
            String test = doc.toJson();
            StringTokenizer tokenizer = new StringTokenizer(test, "\"");
            for (int i = 0; i < 3; i++) {
                tokenizer.nextToken();
            }
            String url = tokenizer.nextToken();
            fotoProfile.setIcon(pruebaFoto(2, url));
        }
    }

    public void setPortrait() {
        Bson projectionFields = Projections.fields(
                Projections.include("kadrBack"),
                Projections.excludeId());
        Document doc = users.find(eq("aemail", currentuser))
                .projection(projectionFields)
                .first();
        if (doc == null) {
            System.out.println("No results found.");
        } else {
            int count = 0;
            String test = doc.toJson();
            StringTokenizer tokenizer = new StringTokenizer(test, "\"");
            for (int i = 0; i < 3; i++) {
                tokenizer.nextToken();
            }
            String url = tokenizer.nextToken();
            fotoBanner.setIcon(pruebaFoto(3, url));
        }
    }

    public void setBio2() {
        String bio = "";

        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentFriend.equals(usuariosss.get(i).getAemail())) {
                bio = usuariosss.get(i).getFbio();
            }
        }
        jTextArea2.setText(bio);
    }

    public void setBio() {
        String bio = "";
        Bson projectionFields = Projections.fields(
                Projections.include("fbio"),
                Projections.excludeId());
        Document doc = users.find(eq("aemail", currentuser))
                .projection(projectionFields)
                .first();
        if (doc == null) {
            jTextArea2.setText("");
        } else {
            String temp = doc.toJson();
            StringTokenizer tokenizer = new StringTokenizer(temp, ":");
            tokenizer = new StringTokenizer(temp, ":");
            tokenizer.nextToken();
            String temp2 = tokenizer.nextToken();
            for (int i = 2; i < temp2.length() - 2; i++) {
                bio += temp2.charAt(i);
            }
            jTextArea2.setText(bio);
        }
    }

    public boolean validarUser(String user, String pass) {
        //Read
        String user11 = user;
        String pass11 = pass;
        System.out.println(user11);
        Bson projectionFields = Projections.fields(
                Projections.include("aemail", "dpassword"),
                Projections.excludeId());
        Document doc = users.find(eq("aemail", user))
                .projection(projectionFields)
                .first();
        if (doc == null) {
            System.out.println("No results found.");
        } else {
            int count = 0;
            String test = doc.toJson();
            String username = "";
            String password = "";
            StringTokenizer tokenizer = new StringTokenizer(test, ",");
            while (tokenizer.hasMoreElements()) {
                if (count == 0) {
                    username = tokenizer.nextToken();
                    System.out.println(username);
                    count++;
                } else {
                    password = tokenizer.nextToken();
                    System.out.println(password);
                }
            }

            //System.out.println("EMAIL: " + extractEmail(username));
            //System.out.println(" PASSWORD: " + extractPassword(dpassword));
            tokenizer = new StringTokenizer(username, ":");
            tokenizer.nextToken();
            String username2 = tokenizer.nextToken();
            tokenizer = new StringTokenizer(password, ":");
            tokenizer.nextToken();
            String password2 = tokenizer.nextToken();
            String username3 = "";
            String password3 = "";
            for (int i = 2; i < username2.length() - 1; i++) {
                username3 += username2.charAt(i);
            }
            for (int i = 2; i < password2.length() - 2; i++) {
                password3 += password2.charAt(i);
            }

            String decoded = "";
            try {
                pass = byteToHex(pass);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(" " + user);
            System.out.print(decoded);
            System.out.println(" " + pass);
            if ((user.equals(username3) && pass.equals(password3))) {
                currentuser = user;
                return true;
            } else if ((user11.equals("admin@gmail.com") && pass11.equals("12345"))) {
                System.out.println(user11);
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
    private void SIbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIbotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SIbotonActionPerformed

    private void SIpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SIpassActionPerformed

    private void SUbotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUbotonMouseClicked
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "SignUpPanel");
    }//GEN-LAST:event_SUbotonMouseClicked

    private void SUbotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUbotonMouseEntered
        Font font = SUboton.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        SUboton.setFont(font.deriveFont(attributes));


    }//GEN-LAST:event_SUbotonMouseEntered

    private void SUbotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUbotonMouseExited
        Font font = SUboton.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
        SUboton.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_SUbotonMouseExited

    private void SIbotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIbotonMouseEntered
        int growthFactor = -60;
        int red = IsaTheme.getRed() + growthFactor;
        int blue = IsaTheme.getBlue() + growthFactor;
        int green = IsaTheme.getGreen() + growthFactor;
        if (red < 0) {
            red = 0;
        }
        if (green < 0) {
            green = 0;
        }
        if (blue < 0) {
            blue = 0;
        }
        Color colorisa = new Color(red, green, blue);
        SIboton.setBackground(colorisa);
        //Color colorisa = new Color(ERROR, WIDTH, ABORT, ABORT)
    }//GEN-LAST:event_SIbotonMouseEntered

    private void SIbotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIbotonMouseExited
        SIboton.setBackground(IsaTheme);
    }//GEN-LAST:event_SIbotonMouseExited

    private void SUboton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUboton1MouseClicked
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "SignInPanel");
        SUemail.setText("");
        SUpass.setText("");
        SUname.setText("");
        SUsur.setText("");
        Date date = new Date();
        SUbd.setDate(date);
    }//GEN-LAST:event_SUboton1MouseClicked

    private void SUboton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUboton1MouseEntered
        Font font = SUboton1.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        SUboton1.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_SUboton1MouseEntered

    private void SUboton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUboton1MouseExited
        Font font = SUboton1.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
        SUboton1.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_SUboton1MouseExited

    private void SignUpBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpBotonMouseEntered
        int growthFactor = -60;
        int red = IsaTheme.getRed() + growthFactor;
        int blue = IsaTheme.getBlue() + growthFactor;
        int green = IsaTheme.getGreen() + growthFactor;
        if (red < 0) {
            red = 0;
        }
        if (green < 0) {
            green = 0;
        }
        if (blue < 0) {
            blue = 0;
        }
        Color colorisa = new Color(red, green, blue);
        SignUpBoton.setBackground(colorisa);
    }//GEN-LAST:event_SignUpBotonMouseEntered

    private void SignUpBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpBotonMouseExited
        SignUpBoton.setBackground(IsaTheme);
    }//GEN-LAST:event_SignUpBotonMouseExited

    private void signOutBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutBotonMouseClicked
        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, "SignInPanel");
        currentuser = "";
        refresh();
    }//GEN-LAST:event_signOutBotonMouseClicked

    private void refreshBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBotonMouseClicked
        refresh();
    }//GEN-LAST:event_refreshBotonMouseClicked

    private void homeBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBotonMouseClicked
        refresh();
    }//GEN-LAST:event_homeBotonMouseClicked

    private void searchBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBotonMouseClicked
        actualuwu = false;
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "searchPanel");
        feedOn = false;
        Font f = searchBoton.getFont();
        searchBoton.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        f = homeBoton.getFont();
        homeBoton.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
        f = profileBoton.getFont();
        profileBoton.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
        current = false;
        newBio.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        ConfigurarCuentaButton.setVisible(false);
    }//GEN-LAST:event_searchBotonMouseClicked

    private void newTweetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTweetMouseClicked
        mostrarNewPost();
        panelProfile.repaint();
    }//GEN-LAST:event_newTweetMouseClicked

    private void newTweetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTweetMouseEntered
        int growthFactor = -60;
        int red = IsaTheme.getRed() + growthFactor;
        int blue = IsaTheme.getBlue() + growthFactor;
        int green = IsaTheme.getGreen() + growthFactor;
        if (red < 0) {
            red = 0;
        }
        if (green < 0) {
            green = 0;
        }
        if (blue < 0) {
            blue = 0;
        }
        Color colorisa = new Color(red, green, blue);
        newTweet.setBackground(colorisa);
    }//GEN-LAST:event_newTweetMouseEntered

    private void newTweetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTweetMouseExited
        newTweet.setBackground(IsaTheme);
    }//GEN-LAST:event_newTweetMouseExited

    private void newTweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTweetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newTweetActionPerformed

    private void newTweet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTweet1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newTweet1ActionPerformed
    public void generatePost(String postt, String address, String name) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String mail = currentuser;
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date fecha = Date.from(instant);
        System.out.println("FECHA: " + fecha);
        ArrayList<Comments> comments = new ArrayList();
        Posts post = new Posts(mail, postt, fecha, comments, address, name);
        posties.add(post);
        posts.insertOne(post);
        fetchPosts();
        JOptionPane.showMessageDialog(null, "Post hecho exitosamente!");
        System.out.println(posties);
    }
    private void newTweet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTweet2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newTweet2ActionPerformed
    public File fichero = new File("\\C:\\Users\\eagui\\OneDrive\\Escritorio\\picTrial.jpg\\");
    public GridFSBucket gridFSBucket = GridFSBuckets.create(db);

    public void uploadPropic() throws FileNotFoundException, IOException {

        String filePath = this.fichero.toString();
        try ( InputStream streamToUploadFrom = new FileInputStream(filePath)) {
            GridFSUploadOptions options = new GridFSUploadOptions()
                    .chunkSizeBytes(1048576)
                    .metadata(new Document("type", "jpg"));
            ObjectId fileId = gridFSBucket.uploadFromStream("picTrial.jpg", streamToUploadFrom, options);
            System.out.println("The file id of the uploaded file is: " + fileId.toHexString());
        }
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                usuariosss.get(i).setIadrPropic(filePath);
            }
        }
    }

    public void uploadPost(String address, String name) throws FileNotFoundException, IOException {
        // String filePath = this.fichero.toString();
        try ( InputStream streamToUploadFrom = new FileInputStream(address)) {
            GridFSUploadOptions options = new GridFSUploadOptions()
                    .chunkSizeBytes(1048576)
                    .metadata(new Document("type", "jpg"));
            ObjectId fileId = gridFSBucket.uploadFromStream(name, streamToUploadFrom, options);
            System.out.println("The file id of the uploaded file is: " + fileId.toHexString());
        }

        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                usuariosss.get(i).getJadrPosts().add(address);
            }
        }
    }
    private void newTweet2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTweet2MouseClicked

        FileInputStream entrada = null;
        ObjectInputStream objeto = null;

        try {
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filtro
                    = new FileNameExtensionFilter(
                            "imagen", "jpg", "jpeg", "png");
            jfc.setFileFilter(filtro);
            int seleccion = jfc.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero2 = jfc.getSelectedFile();
                fotoName = fichero2.getName();
                System.out.println("FICHERO: " + fichero);
                //  System.out.println("supuesto nombre: " + fichero.getName());
                /*entrada = new FileInputStream(fichero);
                System.out.println("ENTRADA:" +entrada);
                objeto = new ObjectInputStream(entrada);
                System.out.println(objeto);*/

                BufferedImage img = ImageIO.read(new File(fichero2.toString()));

                BufferedImage img2 = resize(img, panelFoto.getWidth(), panelFoto.getHeight());
                //BufferedImage img2 = resize(img, 100,100);

                ImageIcon icon = new ImageIcon(img2);

                int width = img2.getWidth();
                BufferedImage circleBuffer = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = circleBuffer.createGraphics();
                g2.setClip(new Ellipse2D.Float(0, 0, width, width));
                g2.drawImage(img2, 0, 0, width, width, null);
                ImageIcon icon2 = new ImageIcon(circleBuffer);
                //JFrame frame = new JFrame();
                //frame.setLayout(new FlowLayout());
                //frame.setSize(200, 300);
                //JLabel lbl = new JLabel();
                panelFoto.setIcon(icon2);
                //frame.add(lbl);
                //frame.setVisible(true);
            } //fin if

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_newTweet2MouseClicked
    public String fotoName = "";
    public File fichero2;
    private void refreshBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBotonMouseEntered
        Font font = refreshBoton.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        refreshBoton.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_refreshBotonMouseEntered

    private void refreshBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBotonMouseExited
        Font font = refreshBoton.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
        refreshBoton.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_refreshBotonMouseExited

    private void signOutBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutBotonMouseEntered
        Font font = signOutBoton.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        signOutBoton.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_signOutBotonMouseEntered

    private void signOutBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutBotonMouseExited
        Font font = signOutBoton.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
        signOutBoton.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_signOutBotonMouseExited

    public <T> ArrayList<T> intersection(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> list = new ArrayList<T>();

        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }


    private void SIboton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIboton1MouseClicked
        String buscar = searchBar.getText();
        //  String nombres3="";
        //String apellidos3="";
        //String email3="";
        if (buscar.isBlank()) {
            JOptionPane.showMessageDialog(null, "Porfavor ingresar una busqueda valida.");
        } else {
            /* for (int i = 0; i < usuariosss.size(); i++) {
                if(buscar.equals(usuariosss.get(i).getEmail())){
                    nombres3 = usuariosss.get(i).getNombres();
                    apellidos3 = usuariosss.get(i).getApellidos();
                    email3 = usuariosss.get(i).getEmail();
                }
            }
            searchItems.get(j).searchItemUpdate(nombres3, apellidos3, email3);*/
            StringTokenizer tokenz = new StringTokenizer(buscar, " ");
            System.out.println("TOKENS:\n" + tokenz.toString());
            Bson projectionFields = Projections.fields(
                    Projections.include("bnombres", "capellidos", "aemail"),
                    Projections.excludeId());
            /*Document doc = users.find(eq("aemail", buscar))
                .projection(projectionFields)
                .first();*/

            String tokens = tokenz.nextToken();
            ArrayList<Document> doco2 = users.find(Filters.regex("bnombres", tokens)).into(new ArrayList<>());
            ArrayList<Document> docArrayList = users.find(Filters.regex("capellidos", tokens)).into(new ArrayList<>());
            System.out.println(doco2);
            docArrayList.addAll(doco2);
            for (int i = 0; i < tokenz.countTokens(); i++) {
                String token = tokenz.nextToken();
                System.out.println("token: " + token);
                ArrayList<Document> doc2 = users.find(Filters.regex("bnombres", token)).into(new ArrayList<>());
                ArrayList<Document> doc3 = users.find(Filters.regex("capellidos", token)).into(new ArrayList<>());
                doc2.addAll(doc3);
                docArrayList = intersection(doc2, docArrayList);
            }
            System.out.println("hi " + docArrayList);

            if (docArrayList == null || docArrayList.isEmpty()) {
                System.out.println("No results found.");
            } else {
                int cuantos = 0;
                for (int j = 0; j < docArrayList.size(); j++) {
                    Document doc = docArrayList.get(j);

                    int count = 0;
                    String test = doc.toJson();
                    String nombres = "";
                    String apellidos = "";
                    String email = "";
                    StringTokenizer tokenizer = new StringTokenizer(test, ",");
                    while (tokenizer.hasMoreElements()) {
                        String jiji = tokenizer.nextToken();
                        //System.out.println(count + ": "+ jiji + "\n");
                        if (count == 2) {
                            nombres = jiji;
                        } else if (count == 3) {
                            apellidos = jiji;
                        } else if (count == 1) {
                            email = jiji;
                        }
                        count++;
                    }
                    System.out.println(nombres);
                    System.out.println(apellidos);
                    System.out.println(email);

                    //System.out.println("\nJIJIJI: " + extractEmail(aemail));
                    tokenizer = new StringTokenizer(nombres, ":");
                    tokenizer.nextToken();
                    String nombres2 = tokenizer.nextToken();
                    tokenizer = new StringTokenizer(apellidos, ":");
                    tokenizer.nextToken();
                    String apellidos2 = tokenizer.nextToken();
                    tokenizer = new StringTokenizer(email, ":");
                    tokenizer.nextToken();
                    String email2 = tokenizer.nextToken();
                    String nombres3 = "";
                    String apellidos3 = "";
                    String email3 = "";
                    for (int i = 2; i < nombres2.length() - 1; i++) {
                        nombres3 += nombres2.charAt(i);
                    }
                    for (int i = 2; i < apellidos2.length() - 1; i++) {
                        apellidos3 += apellidos2.charAt(i);
                    }
                    for (int i = 2; i < email2.length() - 1; i++) {
                        email3 += email2.charAt(i);
                    }
                    searchItems.get(j).searchItemUpdate(nombres3, apellidos3, email3);
                    cuantos = j;
                    System.out.println("\n\nEMAIL: " + email3 + "\nNOMBRE: " + nombres3 + "\nAPELLIDOS: " + apellidos3);
                }
                for (int k = cuantos + 1; k < 9; k++) {
                    searchItems.get(k).Disable();
                }

            }
        }

    }//GEN-LAST:event_SIboton1MouseClicked

    public String extractEmail(String username) {
        System.out.println(username);
        StringTokenizer tokenizer = new StringTokenizer(username, ":");
        tokenizer.nextToken();
        String username2 = tokenizer.nextToken();
        //tokenizer.nextToken();
        String username3 = "";
        for (int i = 2; i < username2.length() - 1; i++) {
            username3 += username2.charAt(i);
        }
        return username3;
    }

    public String extractPassword(String password) {
        StringTokenizer tokenizer = new StringTokenizer(password, ":");
        tokenizer.nextToken();
        String password2 = tokenizer.nextToken();
        String password3 = "";
        for (int i = 2; i < password2.length() - 2; i++) {
            password3 += password2.charAt(i);
        }
        return password3;
    }

    public String extractNombres(String nombres) {
        StringTokenizer tokenizer = new StringTokenizer(nombres, ":");
        tokenizer.nextToken();
        String nombres2 = tokenizer.nextToken();
        String nombres3 = "";

        for (int i = 2; i < nombres2.length() - 1; i++) {
            nombres3 += nombres2.charAt(i);
        }
        return nombres3;
    }

    private void SIboton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIboton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SIboton1MouseEntered

    private void SIboton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIboton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_SIboton1MouseExited

    private void SIboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIboton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SIboton1ActionPerformed

    private void newFollowPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newFollowPanelMouseClicked
    }//GEN-LAST:event_newFollowPanelMouseClicked

    private void newTweet3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTweet3MouseClicked
        String wannabe = "";
        for (int i = 0; i < followRequests.size(); i++) {
            if (followRequests.get(i).getAcceptBox().isSelected()) {
                wannabe = followRequests.get(i).getNameLabel().getText();
                System.out.println("wannabe: " + wannabe);
                System.out.println(i + ": " + followRequests.get(i).getNameLabel().getText());
                for (int j = 0; j < usuariosss.size(); j++) {
                    String current = usuariosss.get(j).getAemail();
                    if (currentuser.equals(current)) {
                        ArrayList<String> currentones = (ArrayList<String>) usuariosss.get(j).getHrequests();
                        System.out.println(currentones);
                        ArrayList<String> friends = new ArrayList();
                        Users actual = null;
                        for (int k = 0; k < usuariosss.size(); k++) {
                            if (wannabe.equals(usuariosss.get(k).getAemail())) {
                                friends = (ArrayList<String>) usuariosss.get(k).getGfriends();
                                actual = usuariosss.get(k);
                            }
                        }
                        System.out.println("user actual: " + actual);

                        for (int k = 0; k < currentones.size(); k++) {
                            if (wannabe.equals(currentones.get(k))) {
                                currentones.remove(k);

                                usuariosss.get(j).setHrequests(currentones);
                                Document newreqs = new Document("aemail", currentuser);
                                FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
                                Users usuarr = userss.find(eq("aemail", currentuser)).first();
                                Users idk = userss.findOneAndReplace(newreqs, usuariosss.get(j), returnDocAfterReplace);
                                System.out.println("supuestamente cambio: " + idk);

                                friends.add(currentuser);
                                Document newreqs1 = new Document("aemail", wannabe);
                                FindOneAndReplaceOptions returnDocAfterReplace1 = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
                                Users usuarr1 = userss.find(eq("aemail", wannabe)).first();
                                Users idk1 = userss.findOneAndReplace(newreqs1, actual, returnDocAfterReplace1);
                                System.out.println("supuestamente cambio: " + idk1);

                                System.out.println(currentones);
                                System.out.println(friends);
                            }
                        }
                    }
                }
            }
        }
        generateFollowRequests();

    }//GEN-LAST:event_newTweet3MouseClicked

    private void newTweet3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTweet3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_newTweet3MouseEntered

    private void newTweet3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTweet3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_newTweet3MouseExited

    private void newTweet3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTweet3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newTweet3ActionPerformed

    public List<String> removeDuplicates(List<String> list) {
        List<String> newList = new ArrayList<String>();
        for (String element : list) {
            if (!newList.contains(element) && !element.equals(currentuser)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public void generateFeed() {
        fetchPosts();
        String usu = currentuser;
        String emaill = "";
        ArrayList<Posts> puwu = new ArrayList();
        ArrayList<String> nombres = new ArrayList();
        List<String> amigos1 = new ArrayList();
        List<String> amigosdeamigos = new ArrayList();
        List<String> amigos = new ArrayList();
        //ArrayList<List> repostLists = new ArrayList();
        ArrayList<ObjectId> repostLists2 = new ArrayList();
        nombres.add("admin@gmail.com");
        nombres.add("Admin");
        boolean flag = false;
        for (int i = 0; i < usuariosss.size(); i++) {
            //Solamente Amigos
            if ((usuariosss.get(i).getAemail().equals(usu) || usuariosss.get(i).getAemail() == usu) && usuariosss.get(i).getConfig() == 0) {
                amigos1 = usuariosss.get(i).getGfriends();
                System.out.println(amigos1 + "*************************");
                flag = false;
                System.out.println("ENTRO A SOLAMENTE AMIGOS**************************************************************");
                break;
            } //Amigos de Amigos
            else if ((usuariosss.get(i).getAemail().equals(usu) || usuariosss.get(i).getAemail() == usu) && usuariosss.get(i).getConfig() == 1) {
                amigos1 = usuariosss.get(i).getGfriends();
                System.out.println(amigos1 + "*************************");
                flag = true;
                System.out.println("ENTRO A AMIGOS DE AMIGOS**************************************************************");
                break;
            }
        }
        if (flag) {
            for (int j = 0; j < amigos1.size(); j++) {
                for (int i = 0; i < usuariosss.size(); i++) {
                    if (usuariosss.get(i).getAemail().equals(amigos1.get(j)) || usuariosss.get(i).getAemail() == amigos1.get(j)) {
                        amigosdeamigos = usuariosss.get(i).getGfriends();
                        break;
                    }
                }
            }
            amigos1.addAll(amigosdeamigos);

            amigos.addAll(removeDuplicates(amigos1));
            System.out.println(amigos);
        } else {
            for (int i = 0; i < amigos1.size(); i++) {
                for (int j = 0; j < usuariosss.size(); j++) {
                    if (usuariosss.get(j).getAemail().equals(amigos1.get(i))) {
                        for (int k = 0; k < usuariosss.get(j).getGfriends().size(); k++) {
                            for (int l = 0; l < usuariosss.size(); l++) {
                                if (usuariosss.get(l).getAemail().equals(usuariosss.get(j).getGfriends().get(k))) {
                                    if (usuariosss.get(l).getConfig() == 1) {
                                        amigosdeamigos.add(usuariosss.get(l).getAemail());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            amigos1.addAll(amigosdeamigos);
            amigos.addAll(removeDuplicates(amigos1));
            System.out.println(amigos);
        }

        for (int i = 0; i < amigos.size(); i++) {
            for (int j = 0; j < usuariosss.size(); j++) {
                if (usuariosss.get(j).getAemail().equals(amigos.get(i))) {
                    if (!usuariosss.get(j).getLreposts().isEmpty()) {
                        //repostLists.add(usuariosss.get(j).getLreposts());
                        repostLists2.addAll(usuariosss.get(j).getLreposts());
                    }/*else{
                        ArrayList ad = new ArrayList();
                        //repostLists.add(ad);
                    }*/
                    break;
                }
            }
        }
        //System.out.println("LISTA REPOSTS: " + repostLists);
        System.out.println("LISTA REPOSTS 2 : " + repostLists2);
        String url = "";
        System.out.println("SIZE: " + posties.size());
        for (int j = 0; j < forFeedPosts.size(); j++) {
            if (forFeedPosts.get(j).getBemail().equals("admin@gmail.com") || forFeedPosts.get(j).getBemail() == "admin@gmail.com") {
                System.out.println("it entered the admin part");
                puwu.add(forFeedPosts.get(j));
            }
            for (int i = 0; i < amigos.size(); i++) {
                //System.out.println("Usuario Revisado: " +posties.get(j).getBemail());
                if (forFeedPosts.get(j).getBemail().equals(amigos.get(i)) || forFeedPosts.get(j).getBemail() == amigos.get(i)) {
                    puwu.add(forFeedPosts.get(j));
                }/*else if(repostLists.get(i).contains(posties.get(j).getId()) && !puwu.contains(posties.get(j).getId())){
                    puwu.add(posties.get(j));
                }*/ else if (repostLists2.contains(forFeedPosts.get(j).getId()) && !puwu.contains(forFeedPosts.get(j))) {

                    puwu.add(forFeedPosts.get(j));
                    System.out.println("ADDED " + i + ": " + puwu);
                }
            }
        }

        for (int j = 0; j < usuariosss.size(); j++) {
            nombres.add(usuariosss.get(j).getAemail());
            nombres.add(usuariosss.get(j).getBnombres() + " " + usuariosss.get(j).getCapellidos());
            /*for (int i = 0; i < amigos.size(); i++) {
                if (usuariosss.get(j).getAemail().equals(amigos.get(i)) || usuariosss.get(j).getAemail() == amigos.get(i)) {
                    nombres.add(usuariosss.get(j).getAemail());
                    nombres.add(usuariosss.get(j).getBnombres() + " " + usuariosss.get(j).getCapellidos());
                }
            }*/
        }

        System.out.println("AMIGOS: " + amigos);
        feedPanel.removeAll();
        feedItemz.clear();
        System.out.println("SIN ORDEN: " + puwu);
        puwu.sort((o1, o2)
                -> o1.getCfecha().compareTo(
                        o2.getCfecha()));
        System.out.println("CON ORDEN: " + puwu);
        int height = 10;
        for (int i = 0; i < puwu.size(); i++) {
            int index = puwu.size() - 1 - i;
            String nombreCompleto = "";
            feedPanel.setPreferredSize(new Dimension(panelProfile.getWidth(), (200 + (i) * 200)));
            String emuwu = "";
            for (int j = 0; j < nombres.size(); j++) {
                if (nombres.get(j).equals(puwu.get(index).getBemail()) || nombres.get(j) == puwu.get(index).getBemail()) {
                    nombreCompleto = nombres.get(j + 1);
                    emuwu = nombres.get(j);
                    break;
                }
            }
            String urlPic = "";
            for (int j = 0; j < usuariosss.size(); j++) {
                if (puwu.get(index).getBemail().equals(usuariosss.get(j).getAemail())) {
                    urlPic = usuariosss.get(j).getIadrPropic();
                }
            }

            Date fechita = forFeedPosts.get(index).getCfecha();
            int fechota = fechita.getHours();
            System.out.println(forFeedPosts.get(index).getEpost());
            Date datie = new Date();
            long secs = (datie.getTime() - fechita.getTime()) / 1000;
            int hours = (int) secs / 3600;
            secs = secs % 3600;
            int mins = (int) secs / 60;
            String timee = hours + " hrs, " + mins + " mins ago.";

            System.out.println("puwuu: " + puwu.get(i));
            url = puwu.get(index).getFurl();
            System.out.println(url);

            System.out.println("POST: " + i);
            postItem postt = new postItem(10, height, panelProfile.getWidth() - 20, 180, puwu.get(index).getBemail(), nombreCompleto, puwu.get(index).getEpost(), puwu.get(index).getCfecha(), url, urlPic, puwu.get(index).getId(), timee);
            System.out.println("en teoria el post: " + postt);
            System.out.println("aqui van las cositas");
            System.out.println(puwu.get(index).getBemail());
            System.out.println(nombreCompleto);
            System.out.println(url);
            System.out.println(puwu.get(i).getEpost());

            if (i < 20) {
                addPostButtons(i, postt);
            }
            if (repostLists2.contains(puwu.get(index).getId())) {
                /*JPanel repuwu = new JPanel();
                repuwu.setSize(postt.postPhoto.getWidth()-50, postt.panelPost.getHeight() - postt.postPhoto.getY() - postt.postPhoto.getHeight()+3);
                repuwu.setLocation(postt.panelPost.getWidth() - repuwu.getWidth(), postt.panelPost.getHeight() - repuwu.getHeight());
                repuwu.setBackground(IsaTheme);*/

                Color white = new Color(0, 0, 0);
                Font fontLabel = new Font("Roboto", Font.BOLD, 15);
                JLabel labuwu = new JLabel();
                postt.getPanelPost().add(labuwu);
                labuwu.setFont(fontLabel);
                labuwu.setForeground(IsaTheme);
                labuwu.setSize(90, 20);
                labuwu.setLocation(postt.getPanelPost().getWidth() - labuwu.getWidth() - 3, postt.getPanelPost().getHeight() - labuwu.getHeight() - 2);

                //labuwu.setBounds(5, 5, 5, 5);
                labuwu.setText("REPOSTED");
                //labuwu.setBorder(null);

                postt.getPanelPost().add(labuwu);
            }
            feedPanel.add(postt.getPanelPost());
            feedItemz.add(postt);
            System.out.println("POST END: " + i);
            height += 200;
        }
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "feedPanel");
    }

    public void generatePosts() {
        String usu = "";
        String nombreCompleto = "";
        ArrayList<Posts> puwu = new ArrayList();

        usu = currentuser;

        for (int i = 0; i < usuariosss.size(); i++) {
            if (usuariosss.get(i).getAemail().equals(usu) || usuariosss.get(i).getAemail() == usu) {
                nombreCompleto = usuariosss.get(i).getBnombres() + " " + usuariosss.get(i).getCapellidos();
                break;
            }
        }
        for (int i = 0; i < posties.size(); i++) {
            if (posties.get(i).getBemail().equals(usu) || posties.get(i).getBemail() == usu) {
                puwu.add(posties.get(i));
            }
        }
        System.out.println("EMAIL: " + usu);
        System.out.println(nombreCompleto);
        System.out.println("OG: " + posties);
        System.out.println("PUWU:" + puwu);
        //panelProfile.setPreferredSize(new Dimension(panelProfile.getWidth(), 5000));
        int y = yy;
        for (int i = 0; i < postItemz.size(); i++) {
            panelProfile.remove(postItemz.get(i).getPanelPost());
        }
        /*   ImageIcon iconLogo = new ImageIcon("\\C:\\Users\\eagui\\OneDrive\\Escritorio\\newpicTrial.jpg\\");
        jLabel1.setIcon(iconLogo);*/
        postItemz.clear();
        //panelProfile.removeAll();
        int height = 620;
        for (int i = 0; i < puwu.size(); i++) {
            int index = puwu.size() - 1 - i;
            String url = puwu.get(index).getFurl();

            panelProfile.setPreferredSize(new Dimension(panelProfile.getWidth(), y + (i * 200)));
            Date fechita = forFeedPosts.get(index).getCfecha();
            int fechota = fechita.getHours();
            System.out.println(forFeedPosts.get(index).getEpost());
            Date datie = new Date();
            long secs = (datie.getTime() - fechita.getTime()) / 1000;
            int hours = (int) secs / 3600;
            secs = secs % 3600;
            int mins = (int) secs / 60;
            String timee = hours + " hrs, " + mins + " mins ago.";

            System.out.println("POST: " + i);
            postItem postt = new postItem(5, height, panelProfile.getWidth() - 20, 180, puwu.get(index).getBemail(), nombreCompleto, puwu.get(index).getEpost(), puwu.get(index).getCfecha(), url, fichero.toString(), puwu.get(index).getId(),timee);
            if (i < 20) {
                addPostButtons(i, postt);
            }
            panelProfile.add(postt.getPanelPost());
            postItemz.add(postt);
            System.out.println("POST END: " + i);
            height += 200;
        }

    }

    public void generateReposts() {
        String usu = "";
        if (actualuwu) {
            usu = currentuser;
        } else {
            usu = currentFriend;
        }
        System.out.println("USU: " + usu);

        String nombreCompleto = "";
        ArrayList<Posts> puwu = new ArrayList();
        ArrayList<ObjectId> repostLists2 = new ArrayList();
        ArrayList<String> nombres = new ArrayList();

        for (int i = 0; i < usuariosss.size(); i++) {
            if (usuariosss.get(i).getAemail().equals(usu)) {
                //nombreCompleto = usuariosss.get(i).getBnombres() + " " + usuariosss.get(i).getCapellidos();
                repostLists2.addAll(usuariosss.get(i).getLreposts());
                break;
            }
        }

        for (int i = 0; i < posties.size(); i++) {
            if (repostLists2.contains(posties.get(i).getId())) {
                puwu.add(posties.get(i));
            }
        }
        for (int j = 0; j < usuariosss.size(); j++) {
            nombres.add(usuariosss.get(j).getAemail());
            nombres.add(usuariosss.get(j).getBnombres() + " " + usuariosss.get(j).getCapellidos());
            /*for (int i = 0; i < amigos.size(); i++) {
                if (usuariosss.get(j).getAemail().equals(amigos.get(i)) || usuariosss.get(j).getAemail() == amigos.get(i)) {
                    nombres.add(usuariosss.get(j).getAemail());
                    nombres.add(usuariosss.get(j).getBnombres() + " " + usuariosss.get(j).getCapellidos());
                }
            }*/
        }
        System.out.println("EMAIL: " + usu);
        System.out.println(nombreCompleto);
        System.out.println("OG: " + posties);
        System.out.println("PUWU:" + puwu);
        //panelProfile.setPreferredSize(new Dimension(panelProfile.getWidth(), 5000));
        int y = yy;
        for (int i = 0; i < postItemz.size(); i++) {
            panelProfile.remove(postItemz.get(i).getPanelPost());
        }
        /*   ImageIcon iconLogo = new ImageIcon("\\C:\\Users\\eagui\\OneDrive\\Escritorio\\newpicTrial.jpg\\");
        jLabel1.setIcon(iconLogo);*/
        postItemz.clear();
        //panelProfile.removeAll();
        int height = 620;
        for (int i = 0; i < puwu.size(); i++) {
            int index = puwu.size() - 1 - i;
            String url = puwu.get(index).getFurl();

            panelProfile.setPreferredSize(new Dimension(panelProfile.getWidth(), y + (i * 200)));

            for (int j = 0; j < nombres.size(); j++) {
                if (nombres.get(j).equals(puwu.get(index).getBemail()) || nombres.get(j) == puwu.get(index).getBemail()) {
                    nombreCompleto = nombres.get(j + 1);
                    break;
                }
            }
            Date fechita = forFeedPosts.get(index).getCfecha();
            int fechota = fechita.getHours();
            System.out.println(forFeedPosts.get(index).getEpost());
            Date datie = new Date();
            long secs = (datie.getTime() - fechita.getTime()) / 1000;
            int hours = (int) secs / 3600;
            secs = secs % 3600;
            int mins = (int) secs / 60;
            String timee = hours + " hrs, " + mins + " mins ago.";

            System.out.println("POST: " + i);
            postItem postt = new postItem(5, height, panelProfile.getWidth() - 20, 180, puwu.get(index).getBemail(), nombreCompleto, puwu.get(index).getEpost(), puwu.get(index).getCfecha(), url, fichero.toString(), puwu.get(index).getId(), timee);
            if (i < 20) {
                addPostButtons(i, postt);
            }
            panelProfile.add(postt.getPanelPost());
            postItemz.add(postt);
            System.out.println("POST END: " + i);
            height += 200;
        }

    }

    public void generatePosts2() {
        String usu = "";
        String nombreCompleto = "";
        ArrayList<Posts> puwu = new ArrayList();

        usu = currentFriend;
        String urlPic = "";
        for (int i = 0; i < usuariosss.size(); i++) {
            if (usuariosss.get(i).getAemail().equals(usu) || usuariosss.get(i).getAemail() == usu) {
                nombreCompleto = usuariosss.get(i).getBnombres() + " " + usuariosss.get(i).getCapellidos();
                urlPic = usuariosss.get(i).getIadrPropic();
                System.out.println("urlPic: " + urlPic);
                break;
            }
        }
        for (int i = 0; i < posties.size(); i++) {
            if (posties.get(i).getBemail().equals(usu) || posties.get(i).getBemail() == usu) {
                puwu.add(posties.get(i));
            }
        }
        System.out.println("EMAIL: " + usu);
        System.out.println(nombreCompleto);
        System.out.println("OG: " + posties);
        System.out.println("PUWU:" + puwu);
        //panelProfile.setPreferredSize(new Dimension(panelProfile.getWidth(), 5000));
        int y = yy;
        for (int i = 0; i < postItemz.size(); i++) {
            panelProfile.remove(postItemz.get(i).getPanelPost());
        }
        /*   ImageIcon iconLogo = new ImageIcon("\\C:\\Users\\eagui\\OneDrive\\Escritorio\\newpicTrial.jpg\\");
        jLabel1.setIcon(iconLogo);*/
        postItemz.clear();
        //panelProfile.removeAll();
        int height = 620;
        for (int i = 0; i < puwu.size(); i++) {
            int index = puwu.size() - 1 - i;
            String url = puwu.get(index).getFurl();

            panelProfile.setPreferredSize(new Dimension(panelProfile.getWidth(), y + (i * 200)));
            Date fechita = forFeedPosts.get(index).getCfecha();
            int fechota = fechita.getHours();
            System.out.println(forFeedPosts.get(index).getEpost());
            Date datie = new Date();
            long secs = (datie.getTime() - fechita.getTime()) / 1000;
            int hours = (int) secs / 3600;
            secs = secs % 3600;
            int mins = (int) secs / 60;
            String timee = hours + " hrs, " + mins + " mins ago.";

            System.out.println("POST: " + i);
            postItem postt = new postItem(5, height, panelProfile.getWidth() - 20, 180, puwu.get(index).getBemail(), nombreCompleto, puwu.get(index).getEpost(), puwu.get(index).getCfecha(), url, urlPic, puwu.get(index).getId(), timee);
            if (i < 20) {
                addPostButtons(i, postt);
            }
            panelProfile.add(postt.getPanelPost());
            postItemz.add(postt);
            System.out.println("POST END: " + i);
            height += 200;
        }
    }

    public void addPostButtons(int i, postItem postt) {
        postt.getPanelPost().add(commentBotonz.get(i));
        commentBotonz.get(i).setLocation(10 + postt.comment.getWidth() + 10, postt.panelPost.getHeight() - 55);
        postt.getPanelPost().add(verCommentBotonz.get(i));
        verCommentBotonz.get(i).setLocation(10 + postt.comment.getWidth() + 10, postt.panelPost.getHeight() - 30);
        postt.getPanelPost().add(repostBotonz.get(i));
        repostBotonz.get(i).setLocation(postt.getPanelPost().getWidth() - repostBotonz.get(i).getWidth() - 10, 5);

    }

    private void profileBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileBotonMouseClicked
        actualuwu = true;
        fetchPosts();
        jTextArea2.setText("");
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");
        current = true;
        feedOn = false;
        updateperfil();
        fotoProfile.setIcon(null);
        setPFP2();
        newBio1.setVisible(false);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        ConfigurarCuentaButton.setVisible(true);
        int index = 0;
        for (int i = 0; i < usuariosss.size(); i++) {
            if (usuariosss.get(i).getAemail().equals(currentuser) || usuariosss.get(i).getAemail() == currentuser) {
                index = i;
                break;
            }
        }
        if (usuariosss.get(index).getConfig() == 0) {
            ConfigurarCuentaButton.setText("Solamente Amigos");
        } else if (usuariosss.get(index).getConfig() == 1) {
            ConfigurarCuentaButton.setText("Amigos de Amigos");
        }
        generatePosts();

        Font f = searchBoton.getFont();
        searchBoton.setFont(f.deriveFont(f.getStyle() | ~Font.BOLD));
        f = homeBoton.getFont();
        homeBoton.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
        f = profileBoton.getFont();
        profileBoton.setFont(f.deriveFont(f.getStyle() & Font.BOLD));
        newBio.setVisible(true);

    }//GEN-LAST:event_profileBotonMouseClicked
    public boolean current;
    private void newBioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBioMouseClicked
        // TODO add your handling code here:
        if (current) {
            Document query = new Document().append("aemail", currentuser);
            Bson updates = Updates.combine(
                    Updates.set("fbio", jTextArea2.getText()));
            UpdateOptions options = new UpdateOptions().upsert(true);
            try {
                UpdateResult result = users.updateOne(query, updates, options);
                JOptionPane.showMessageDialog(null, "Se actualizo su Biografia.");
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
            setBio();
        } else {
            Document query = new Document().append("aemail", currentFriend);
            Bson updates = Updates.combine(
                    Updates.set("fbio", jTextArea2.getText()));
            UpdateOptions options = new UpdateOptions().upsert(true);
            try {
                UpdateResult result = users.updateOne(query, updates, options);
                JOptionPane.showMessageDialog(null, "Se actualizo su Biografia.");
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
            for (int i = 0; i < usuariosss.size(); i++) {
                if (currentFriend.equals(usuariosss.get(i).getAemail())) {
                    usuariosss.get(i).setFbio(jTextArea2.getText());
                }
            }
            setBio2();
        }

    }//GEN-LAST:event_newBioMouseClicked

    private void newBioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_newBioMouseEntered

    private void newBioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBioMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_newBioMouseExited

    private void newBioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newBioActionPerformed

    private void searchBoton0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton0MouseClicked
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");

        currentFriend = searchEmail0.getText();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                System.out.println("actual: " + usuariosss.get(i));
                List<String> friends = usuariosss.get(i).getGfriends();
                System.out.println("friends: " + friends);
                for (int j = 0; j < friends.size(); j++) {
                    if (currentFriend.equals(friends.get(j))) {
                        current = true;
                        break;
                    } else {
                        current = false;
                    }
                }
            }
        }
        //  current = false;
        System.out.println("current: " + current);
        if (current) {
            newBio1.setVisible(false);
        } else {
            newBio1.setVisible(true);
        }
        generateProfile2();

        generatePosts2();
    }//GEN-LAST:event_searchBoton0MouseClicked
    public void generateProfile2() {
        jLabel5.setText(currentFriend);
        Bson projectionFields = Projections.fields(
                Projections.include("bnombres", "capellidos"),
                Projections.excludeId());
        Document doc = users.find(eq("aemail", currentFriend))
                .projection(projectionFields)
                .first();
        if (doc == null) {
            System.out.println("No results found.");
        } else {
            int count = 0;
            String test = doc.toJson();
            String nombres = "";
            String apellidos = "";
            StringTokenizer tokenizer = new StringTokenizer(test, ",");
            while (tokenizer.hasMoreElements()) {
                if (count == 0) {
                    nombres = tokenizer.nextToken();
                    count++;
                } else {
                    apellidos = tokenizer.nextToken();
                }
            }
            String url = "";
            String urlb = "";
            for (int i = 0; i < usuariosss.size(); i++) {
                if (currentFriend.equals(usuariosss.get(i).getAemail())) {
                    url = usuariosss.get(i).getIadrPropic();
                    urlb = usuariosss.get(i).getKadrBack();
                }
            }
            fotoProfile.setIcon(pruebaFoto(2, url));
            fotoBanner.setIcon(pruebaFoto(3, urlb));

            tokenizer = new StringTokenizer(nombres, ":");
            tokenizer.nextToken();
            String nombres2 = tokenizer.nextToken();
            tokenizer = new StringTokenizer(apellidos, ":");
            tokenizer.nextToken();
            String apellidos2 = tokenizer.nextToken();
            String nombres3 = "";
            String apellidos3 = "";
            for (int i = 2; i < nombres2.length() - 1; i++) {
                nombres3 += nombres2.charAt(i);
            }
            for (int i = 2; i < apellidos2.length() - 2; i++) {
                apellidos3 += apellidos2.charAt(i);
            }
            jLabel6.setText(nombres3 + " " + apellidos3);
            setBio2();
        }
    }
    private void searchBoton0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton0MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton0MouseEntered

    private void searchBoton0MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton0MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton0MouseExited

    private void searchBoton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoton0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton0ActionPerformed

    private void searchBoton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton2MouseClicked
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");

        currentFriend = searchEmail1.getText();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                System.out.println("actual: " + usuariosss.get(i));
                List<String> friends = usuariosss.get(i).getGfriends();
                System.out.println("friends: " + friends);
                for (int j = 0; j < friends.size(); j++) {
                    if (currentFriend.equals(friends.get(j))) {
                        current = true;
                        break;
                    } else {
                        current = false;
                    }
                }
            }
        }
        //  current = false;
        System.out.println("current: " + current);
        if (current) {
            newBio1.setVisible(false);
        } else {
            newBio1.setVisible(true);
        }
        generateProfile2();

        generatePosts2();
    }//GEN-LAST:event_searchBoton2MouseClicked

    private void searchBoton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton2MouseEntered

    private void searchBoton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton2MouseExited

    private void searchBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton2ActionPerformed

    private void searchBoton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton3MouseClicked
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");

        currentFriend = searchEmail2.getText();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                System.out.println("actual: " + usuariosss.get(i));
                List<String> friends = usuariosss.get(i).getGfriends();
                System.out.println("friends: " + friends);
                for (int j = 0; j < friends.size(); j++) {
                    if (currentFriend.equals(friends.get(j))) {
                        current = true;
                        break;
                    } else {
                        current = false;
                    }
                }
            }
        }
        //  current = false;
        System.out.println("current: " + current);
        if (current) {
            newBio1.setVisible(false);
        } else {
            newBio1.setVisible(true);
        }
        generateProfile2();

        generatePosts2();
    }//GEN-LAST:event_searchBoton3MouseClicked

    private void searchBoton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton3MouseEntered

    private void searchBoton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton3MouseExited

    private void searchBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton3ActionPerformed

    private void searchBoton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton4MouseClicked

    private void searchBoton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton4MouseEntered
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");

        currentFriend = searchEmail3.getText();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                System.out.println("actual: " + usuariosss.get(i));
                List<String> friends = usuariosss.get(i).getGfriends();
                System.out.println("friends: " + friends);
                for (int j = 0; j < friends.size(); j++) {
                    if (currentFriend.equals(friends.get(j))) {
                        current = true;
                        break;
                    } else {
                        current = false;
                    }
                }
            }
        }
        //  current = false;
        System.out.println("current: " + current);
        if (current) {
            newBio1.setVisible(false);
        } else {
            newBio1.setVisible(true);
        }
        generateProfile2();

        generatePosts2();
    }//GEN-LAST:event_searchBoton4MouseEntered

    private void searchBoton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton4MouseExited

    private void searchBoton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton4ActionPerformed

    private void searchBoton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton5MouseClicked
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");

        currentFriend = searchEmail4.getText();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                System.out.println("actual: " + usuariosss.get(i));
                List<String> friends = usuariosss.get(i).getGfriends();
                System.out.println("friends: " + friends);
                for (int j = 0; j < friends.size(); j++) {
                    if (currentFriend.equals(friends.get(j))) {
                        current = true;
                        break;
                    } else {
                        current = false;
                    }
                }
            }
        }
        //  current = false;
        System.out.println("current: " + current);
        if (current) {
            newBio1.setVisible(false);
        } else {
            newBio1.setVisible(true);
        }
        generateProfile2();

        generatePosts2();
    }//GEN-LAST:event_searchBoton5MouseClicked

    private void searchBoton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton5MouseEntered

    private void searchBoton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton5MouseExited

    private void searchBoton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton5ActionPerformed

    private void searchBoton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton6MouseClicked
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");

        currentFriend = searchEmail5.getText();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                System.out.println("actual: " + usuariosss.get(i));
                List<String> friends = usuariosss.get(i).getGfriends();
                System.out.println("friends: " + friends);
                for (int j = 0; j < friends.size(); j++) {
                    if (currentFriend.equals(friends.get(j))) {
                        current = true;
                        break;
                    } else {
                        current = false;
                    }
                }
            }
        }
        //  current = false;
        System.out.println("current: " + current);
        if (current) {
            newBio1.setVisible(false);
        } else {
            newBio1.setVisible(true);
        }
        generateProfile2();

        generatePosts2();
    }//GEN-LAST:event_searchBoton6MouseClicked

    private void searchBoton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton6MouseEntered

    private void searchBoton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton6MouseExited

    private void searchBoton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton6ActionPerformed

    private void searchBoton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton7MouseClicked
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");

        currentFriend = searchEmail6.getText();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                System.out.println("actual: " + usuariosss.get(i));
                List<String> friends = usuariosss.get(i).getGfriends();
                System.out.println("friends: " + friends);
                for (int j = 0; j < friends.size(); j++) {
                    if (currentFriend.equals(friends.get(j))) {
                        current = true;
                        break;
                    } else {
                        current = false;
                    }
                }
            }
        }
        //  current = false;
        System.out.println("current: " + current);
        if (current) {
            newBio1.setVisible(false);
        } else {
            newBio1.setVisible(true);
        }
        generateProfile2();

        generatePosts2();
    }//GEN-LAST:event_searchBoton7MouseClicked

    private void searchBoton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton7MouseEntered

    private void searchBoton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton7MouseExited

    private void searchBoton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton7ActionPerformed

    private void searchBoton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton8MouseClicked
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");

        currentFriend = searchEmail7.getText();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                System.out.println("actual: " + usuariosss.get(i));
                List<String> friends = usuariosss.get(i).getGfriends();
                System.out.println("friends: " + friends);
                for (int j = 0; j < friends.size(); j++) {
                    if (currentFriend.equals(friends.get(j))) {
                        current = true;
                        break;
                    } else {
                        current = false;
                    }
                }
            }
        }
        //  current = false;
        System.out.println("current: " + current);
        if (current) {
            newBio1.setVisible(false);
        } else {
            newBio1.setVisible(true);
        }
        generateProfile2();

        generatePosts2();
    }//GEN-LAST:event_searchBoton8MouseClicked

    private void searchBoton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton8MouseEntered

    private void searchBoton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton8MouseExited

    private void searchBoton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton8ActionPerformed

    private void searchBoton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton9MouseClicked
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "profileView");

        currentFriend = searchEmail8.getText();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                System.out.println("actual: " + usuariosss.get(i));
                List<String> friends = usuariosss.get(i).getGfriends();
                System.out.println("friends: " + friends);
                for (int j = 0; j < friends.size(); j++) {
                    if (currentFriend.equals(friends.get(j))) {
                        current = true;
                        break;
                    } else {
                        current = false;
                    }
                }
            }
        }
        //  current = false;
        System.out.println("current: " + current);
        if (current) {
            newBio1.setVisible(false);
        } else {
            newBio1.setVisible(true);
        }
        generateProfile2();

        generatePosts2();
    }//GEN-LAST:event_searchBoton9MouseClicked

    private void searchBoton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton9MouseEntered

    private void searchBoton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton9MouseExited

    private void searchBoton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton9ActionPerformed
    public BufferedImage bi;
    private void newTweet1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTweet1MouseClicked
        if (panelFoto.getIcon() == null) {
            String forPost = textPostJT.getText();
            generatePost(forPost, "", fotoName);
            textPostJT.setText("");
            NewPostDialog.dispose();
        } else {
            String forPost = textPostJT.getText();
            Icon icon = panelFoto.getIcon();
            BufferedImage bi = new BufferedImage(icon.getIconWidth(),
                    icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);

            generatePost(forPost, fichero2.toString(), fotoName);
            Icon icon2 = panelFoto.getIcon();
            bi = new BufferedImage(icon2.getIconWidth(),
                    icon2.getIconHeight(), BufferedImage.TYPE_INT_RGB);

            textPostJT.setText("");
            NewPostDialog.dispose();
        }

    }//GEN-LAST:event_newTweet1MouseClicked

    private void newBio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBio1MouseClicked
        for (int i = 0; i < usuariosss.size(); i++) {
            Users curr = usuariosss.get(i);
            if (currentFriend.equals(usuariosss.get(i).getAemail())) {
                List<String> reqs = curr.getHrequests();
                reqs.add(currentuser);
                curr.setHrequests(reqs);
                Document newreqs = new Document("aemail", curr.getAemail());
                FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
                Users usuarr = userss.find(eq("aemail", currentFriend)).first();
                Users idk = userss.findOneAndReplace(newreqs, curr, returnDocAfterReplace);
                JOptionPane.showMessageDialog(null, "Solicitud Enviada Correctamente!");
            }
        }
    }//GEN-LAST:event_newBio1MouseClicked

    private void newBio1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBio1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_newBio1MouseEntered

    private void newBio1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newBio1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_newBio1MouseExited

    private void newBio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newBio1ActionPerformed

    private void fotoProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fotoProfileMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        //Editar Portada
        FileInputStream entrada = null;
        ObjectInputStream objeto = null;

        try {
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filtro
                    = new FileNameExtensionFilter(
                            "imagen", "jpg", "jpeg", "png");
            jfc.setFileFilter(filtro);
            int seleccion = jfc.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero2 = jfc.getSelectedFile();
                fotoName = fichero2.getName();
                System.out.println("FICHERO: " + fichero2);

                BufferedImage img = ImageIO.read(new File(fichero2.toString()));
                BufferedImage img2 = resize(img, fotoBanner.getWidth(), fotoBanner.getHeight());

                ImageIcon icon = new ImageIcon(img2);
                fotoBanner.setIcon(icon);
                setPFP2();
                System.out.println(currentuser);
                Document query = new Document().append("aemail", currentuser);
                Bson updates = Updates.combine(
                        Updates.set("kadrBack", fichero2.toString()));
                UpdateOptions options = new UpdateOptions().upsert(true);
                System.out.println("Se actulizo la foto de portada");
                for (int i = 0; i < usuariosss.size(); i++) {
                    if (currentuser.equals(usuariosss.get(i).getAemail())) {
                        usuariosss.get(i).setKadrBack(fichero2.toString());
                    }
                }
                try {
                    UpdateResult result = users.updateOne(query, updates, options);
                } catch (MongoException me) {
                    System.err.println("Unable to update due to an error: " + me);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        panelProfile.repaint();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        //Editar Foto
        FileInputStream entrada = null;
        ObjectInputStream objeto = null;

        try {
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filtro
                    = new FileNameExtensionFilter(
                            "imagen", "jpg", "jpeg", "png");
            jfc.setFileFilter(filtro);
            int seleccion = jfc.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fichero2 = jfc.getSelectedFile();
                fotoName = fichero2.getName();
                System.out.println("FICHERO: " + fichero2);

                BufferedImage img = ImageIO.read(new File(fichero2.toString()));
                BufferedImage img2 = resize(img, fotoProfile.getWidth(), fotoProfile.getHeight());

                ImageIcon icon = new ImageIcon(img2);

                int width = img2.getWidth();
                BufferedImage circleBuffer = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = circleBuffer.createGraphics();
                g2.setClip(new Ellipse2D.Float(0, 0, width, width));
                g2.drawImage(img2, 0, 0, width, width, null);
                ImageIcon icon2 = new ImageIcon(circleBuffer);
                fotoProfile.setIcon(icon2);
                System.out.println(currentuser);
                Document query = new Document().append("aemail", currentuser);
                Bson updates = Updates.combine(
                        Updates.set("iadrPropic", fichero2.toString()));
                UpdateOptions options = new UpdateOptions().upsert(true);
                System.out.println("Se actulizo la foto de perfil");
                for (int i = 0; i < usuariosss.size(); i++) {
                    if (currentuser.equals(usuariosss.get(i).getAemail())) {
                        usuariosss.get(i).setIadrPropic(fichero2.toString());
                    }
                }
                try {
                    UpdateResult result = users.updateOne(query, updates, options);
                } catch (MongoException me) {
                    System.err.println("Unable to update due to an error: " + me);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        panelProfile.repaint();
    }//GEN-LAST:event_jButton2MouseClicked

    private void fotoBannerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoBannerMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_fotoBannerMouseClicked

    private void feedPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feedPanelMouseClicked
        System.out.println("Y VALUE: " + evt.getY());
    }//GEN-LAST:event_feedPanelMouseClicked

    private void commentBoton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton1MouseClicked
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(1).id;
            comment = feedItemz.get(1).comment.getText();
            feedItemz.get(1).comment.setText("");
        } else {
            idd = postItemz.get(1).id;
            comment = postItemz.get(1).comment.getText();
            postItemz.get(1).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton1MouseClicked

    private void commentBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton1ActionPerformed

    private void commentBoton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton2MouseClicked
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(2).id;
            comment = feedItemz.get(2).comment.getText();
            feedItemz.get(2).comment.setText("");
        } else {
            idd = postItemz.get(2).id;
            comment = postItemz.get(2).comment.getText();
            postItemz.get(2).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton2MouseClicked

    private void commentBoton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton2MouseEntered

    private void commentBoton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton2MouseExited

    private void commentBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton2ActionPerformed

    private void commentBoton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton3MouseClicked
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(3).id;
            comment = feedItemz.get(3).comment.getText();
            feedItemz.get(3).comment.setText("");
        } else {
            idd = postItemz.get(3).id;
            comment = postItemz.get(3).comment.getText();
            postItemz.get(3).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton3MouseClicked

    private void commentBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton3ActionPerformed

    private void commentBoton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton4MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(4).id;
            comment = feedItemz.get(4).comment.getText();
            feedItemz.get(4).comment.setText("");
        } else {
            idd = postItemz.get(4).id;
            comment = postItemz.get(4).comment.getText();
            postItemz.get(4).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton4MouseClicked

    private void commentBoton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton4ActionPerformed

    private void commentBoton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton5MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(5).id;
            comment = feedItemz.get(5).comment.getText();
            feedItemz.get(5).comment.setText("");
        } else {
            idd = postItemz.get(5).id;
            comment = postItemz.get(5).comment.getText();
            postItemz.get(5).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton5MouseClicked

    private void commentBoton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton5ActionPerformed

    private void commentBoton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton6MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(6).id;
            comment = feedItemz.get(6).comment.getText();
            feedItemz.get(6).comment.setText("");
        } else {
            idd = postItemz.get(6).id;
            comment = postItemz.get(6).comment.getText();
            postItemz.get(6).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton6MouseClicked

    private void commentBoton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton6ActionPerformed

    private void commentBoton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton7MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(7).id;
            comment = feedItemz.get(7).comment.getText();
            feedItemz.get(7).comment.setText("");
        } else {
            idd = postItemz.get(7).id;
            comment = postItemz.get(7).comment.getText();
            postItemz.get(7).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton7MouseClicked

    private void commentBoton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton7ActionPerformed

    private void commentBoton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton8MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(8).id;
            comment = feedItemz.get(8).comment.getText();
            feedItemz.get(8).comment.setText("");
        } else {
            idd = postItemz.get(8).id;
            comment = postItemz.get(8).comment.getText();
            postItemz.get(8).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton8MouseClicked

    private void commentBoton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton8ActionPerformed

    private void commentBoton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton9MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(9).id;
            comment = feedItemz.get(9).comment.getText();
            feedItemz.get(9).comment.setText("");
        } else {
            idd = postItemz.get(9).id;
            comment = postItemz.get(9).comment.getText();
            postItemz.get(9).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton9MouseClicked

    private void commentBoton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton9ActionPerformed

    private void commentBoton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton10MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(10).id;
            comment = feedItemz.get(10).comment.getText();
            feedItemz.get(10).comment.setText("");
        } else {
            idd = postItemz.get(10).id;
            comment = postItemz.get(10).comment.getText();
            postItemz.get(10).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton10MouseClicked

    private void commentBoton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton10ActionPerformed

    private void commentBoton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton11MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(11).id;
            comment = feedItemz.get(11).comment.getText();
            feedItemz.get(11).comment.setText("");
        } else {
            idd = postItemz.get(11).id;
            comment = postItemz.get(11).comment.getText();
            postItemz.get(11).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton11MouseClicked

    private void commentBoton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton11ActionPerformed

    private void commentBoton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton12MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(12).id;
            comment = feedItemz.get(12).comment.getText();
            feedItemz.get(12).comment.setText("");
        } else {
            idd = postItemz.get(12).id;
            comment = postItemz.get(12).comment.getText();
            postItemz.get(12).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton12MouseClicked

    private void commentBoton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton12ActionPerformed

    private void commentBoton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton13MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(13).id;
            comment = feedItemz.get(13).comment.getText();
            feedItemz.get(13).comment.setText("");
        } else {
            idd = postItemz.get(13).id;
            comment = postItemz.get(13).comment.getText();
            postItemz.get(13).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton13MouseClicked

    private void commentBoton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton13ActionPerformed

    private void commentBoton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton14MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(14).id;
            comment = feedItemz.get(14).comment.getText();
            feedItemz.get(14).comment.setText("");
        } else {
            idd = postItemz.get(14).id;
            comment = postItemz.get(14).comment.getText();
            postItemz.get(14).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton14MouseClicked

    private void commentBoton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton14ActionPerformed

    private void commentBoton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton15MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(15).id;
            comment = feedItemz.get(15).comment.getText();
            feedItemz.get(15).comment.setText("");
        } else {
            idd = postItemz.get(15).id;
            comment = postItemz.get(15).comment.getText();
            postItemz.get(15).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton15MouseClicked

    private void commentBoton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton15ActionPerformed

    private void commentBoton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton16MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(16).id;
            comment = feedItemz.get(16).comment.getText();
            feedItemz.get(16).comment.setText("");
        } else {
            idd = postItemz.get(16).id;
            comment = postItemz.get(16).comment.getText();
            postItemz.get(16).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton16MouseClicked

    private void commentBoton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton16ActionPerformed

    private void commentBoton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton17MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(17).id;
            comment = feedItemz.get(17).comment.getText();
            feedItemz.get(17).comment.setText("");
        } else {
            idd = postItemz.get(17).id;
            comment = postItemz.get(17).comment.getText();
            postItemz.get(17).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton17MouseClicked

    private void commentBoton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton17ActionPerformed

    private void commentBoton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton18MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(18).id;
            comment = feedItemz.get(18).comment.getText();
            feedItemz.get(18).comment.setText("");
        } else {
            idd = postItemz.get(18).id;
            comment = postItemz.get(18).comment.getText();
            postItemz.get(18).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton18MouseClicked

    private void commentBoton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton18ActionPerformed

    private void commentBoton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton19MouseClicked
        // TODO add your handling code here:
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(19).id;
            comment = feedItemz.get(19).comment.getText();
            feedItemz.get(19).comment.setText("");
        } else {
            idd = postItemz.get(19).id;
            comment = postItemz.get(19).comment.getText();
            postItemz.get(19).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton19MouseClicked

    private void commentBoton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentBoton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentBoton19ActionPerformed

    private void vercommentBoton0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton0MouseClicked
        // TODO add your handling code here:
        mostrarcomments(0);

    }//GEN-LAST:event_vercommentBoton0MouseClicked

    private void vercommentBoton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton0ActionPerformed

    private void vercommentBoton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton1MouseClicked
        // TODO add your handling code here:
        mostrarcomments(1);
    }//GEN-LAST:event_vercommentBoton1MouseClicked

    private void vercommentBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton1ActionPerformed

    private void vercommentBoton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton2MouseClicked
        // TODO add your handling code here:
        mostrarcomments(2);
    }//GEN-LAST:event_vercommentBoton2MouseClicked

    private void vercommentBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton2ActionPerformed

    private void vercommentBoton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton3MouseClicked
        // TODO add your handling code here:
        mostrarcomments(3);
    }//GEN-LAST:event_vercommentBoton3MouseClicked

    private void vercommentBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton3ActionPerformed

    private void vercommentBoton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton4MouseClicked
        // TODO add your handling code here:
        mostrarcomments(4);
    }//GEN-LAST:event_vercommentBoton4MouseClicked

    private void vercommentBoton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton4ActionPerformed

    private void vercommentBoton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton5MouseClicked
        // TODO add your handling code here:
        mostrarcomments(5);
    }//GEN-LAST:event_vercommentBoton5MouseClicked

    private void vercommentBoton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton5ActionPerformed

    private void vercommentBoton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton6MouseClicked
        // TODO add your handling code here:
        mostrarcomments(6);
    }//GEN-LAST:event_vercommentBoton6MouseClicked

    private void vercommentBoton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton6ActionPerformed

    private void vercommentBoton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton7MouseClicked
        // TODO add your handling code here:
        mostrarcomments(7);
    }//GEN-LAST:event_vercommentBoton7MouseClicked

    private void vercommentBoton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton7ActionPerformed

    private void vercommentBoton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton8MouseClicked
        // TODO add your handling code here:
        mostrarcomments(8);
    }//GEN-LAST:event_vercommentBoton8MouseClicked

    private void vercommentBoton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton8ActionPerformed

    private void vercommentBoton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton9MouseClicked
        // TODO add your handling code here:
        mostrarcomments(9);
    }//GEN-LAST:event_vercommentBoton9MouseClicked

    private void vercommentBoton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton9ActionPerformed

    private void vercommentBoton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton10MouseClicked
        // TODO add your handling code here:
        mostrarcomments(10);
    }//GEN-LAST:event_vercommentBoton10MouseClicked

    private void vercommentBoton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton10ActionPerformed

    private void vercommentBoton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton11MouseClicked
        // TODO add your handling code here:
        mostrarcomments(11);
    }//GEN-LAST:event_vercommentBoton11MouseClicked

    private void vercommentBoton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton11ActionPerformed

    private void vercommentBoton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton12MouseClicked
        // TODO add your handling code here:
        mostrarcomments(12);
    }//GEN-LAST:event_vercommentBoton12MouseClicked

    private void vercommentBoton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton12ActionPerformed

    private void vercommentBoton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton13MouseClicked
        // TODO add your handling code here:
        mostrarcomments(13);
    }//GEN-LAST:event_vercommentBoton13MouseClicked

    private void vercommentBoton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton13ActionPerformed

    private void vercommentBoton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton14MouseClicked
        // TODO add your handling code here:
        mostrarcomments(14);
    }//GEN-LAST:event_vercommentBoton14MouseClicked

    private void vercommentBoton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton14ActionPerformed

    private void vercommentBoton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton15MouseClicked
        // TODO add your handling code here:
        mostrarcomments(15);
    }//GEN-LAST:event_vercommentBoton15MouseClicked

    private void vercommentBoton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton15ActionPerformed

    private void vercommentBoton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton16MouseClicked
        // TODO add your handling code here:
        mostrarcomments(16);
    }//GEN-LAST:event_vercommentBoton16MouseClicked

    private void vercommentBoton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton16ActionPerformed

    private void vercommentBoton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton17MouseClicked
        // TODO add your handling code here:
        mostrarcomments(17);
    }//GEN-LAST:event_vercommentBoton17MouseClicked

    private void vercommentBoton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton17ActionPerformed

    private void vercommentBoton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton18MouseClicked
        // TODO add your handling code here:
        mostrarcomments(18);
    }//GEN-LAST:event_vercommentBoton18MouseClicked

    private void vercommentBoton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton18ActionPerformed

    private void vercommentBoton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vercommentBoton19MouseClicked
        // TODO add your handling code here:
        mostrarcomments(19);
    }//GEN-LAST:event_vercommentBoton19MouseClicked

    private void vercommentBoton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vercommentBoton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vercommentBoton19ActionPerformed

    private void searchBoton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoton1MouseClicked

    private void repostBoton0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton0MouseClicked
        repost(0);
    }//GEN-LAST:event_repostBoton0MouseClicked

    public void repost(int index) {
        List<ObjectId> reposts = new ArrayList<>();
        for (int i = 0; i < usuariosss.size(); i++) {
            if (usuariosss.get(i).getAemail().equals(currentuser)) {

                reposts = (ArrayList) usuariosss.get(i).getLreposts();
                ObjectId idd;
                if (feedOn) {
                    idd = feedItemz.get(index).id;

                } else {
                    idd = postItemz.get(index).id;
                }
                if (reposts.contains(idd)) {
                    JOptionPane.showMessageDialog(null, "Ya ha Reposted este Post.");
                } else {
                    reposts.add(idd);//ahi va el id

                    usuariosss.get(i).setLreposts(reposts);
                    Document newreqs = new Document("aemail", currentuser);
                    FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
                    Users usuarr = userss.find(eq("aemail", currentuser)).first();
                    Users idk = userss.findOneAndReplace(newreqs, usuariosss.get(i), returnDocAfterReplace);
                    System.out.println("supuestamente cambio: " + idk);
                }
            }
        }
    }

    private void repostBoton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton0ActionPerformed

    }//GEN-LAST:event_repostBoton0ActionPerformed

    private void repostBoton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton1MouseClicked
        repost(1);
    }//GEN-LAST:event_repostBoton1MouseClicked

    private void repostBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton1ActionPerformed

    private void repostBoton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton2MouseClicked
        repost(2);
    }//GEN-LAST:event_repostBoton2MouseClicked

    private void repostBoton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton2ActionPerformed

    private void repostBoton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton3MouseClicked
        repost(3);
    }//GEN-LAST:event_repostBoton3MouseClicked

    private void repostBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton3ActionPerformed

    private void repostBoton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton4MouseClicked
        repost(4);
    }//GEN-LAST:event_repostBoton4MouseClicked

    private void repostBoton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton4ActionPerformed

    private void repostBoton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton5MouseClicked
        repost(5);
    }//GEN-LAST:event_repostBoton5MouseClicked

    private void repostBoton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton5ActionPerformed

    private void repostBoton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton6MouseClicked
        repost(6);
    }//GEN-LAST:event_repostBoton6MouseClicked

    private void repostBoton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton6ActionPerformed

    private void repostBoton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton7MouseClicked
        repost(7);
    }//GEN-LAST:event_repostBoton7MouseClicked

    private void repostBoton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton7ActionPerformed

    private void repostBoton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton8MouseClicked
        repost(8);
    }//GEN-LAST:event_repostBoton8MouseClicked

    private void repostBoton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton8ActionPerformed

    private void repostBoton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton9MouseClicked
        repost(9);
    }//GEN-LAST:event_repostBoton9MouseClicked

    private void repostBoton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton9ActionPerformed

    private void repostBoton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton10MouseClicked
        repost(10);
    }//GEN-LAST:event_repostBoton10MouseClicked

    private void repostBoton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton10ActionPerformed

    }//GEN-LAST:event_repostBoton10ActionPerformed

    private void repostBoton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton11MouseClicked
        repost(11);
    }//GEN-LAST:event_repostBoton11MouseClicked

    private void repostBoton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton11ActionPerformed

    private void repostBoton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton12MouseClicked
        repost(12);
    }//GEN-LAST:event_repostBoton12MouseClicked

    private void repostBoton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton12ActionPerformed

    private void repostBoton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton13MouseClicked
        repost(13);
    }//GEN-LAST:event_repostBoton13MouseClicked

    private void repostBoton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton13ActionPerformed

    private void repostBoton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton14MouseClicked
        repost(14);
    }//GEN-LAST:event_repostBoton14MouseClicked

    private void repostBoton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton14ActionPerformed

    private void repostBoton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton15MouseClicked
        repost(15);
    }//GEN-LAST:event_repostBoton15MouseClicked

    private void repostBoton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton15ActionPerformed

    private void repostBoton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton16MouseClicked
        repost(16);
    }//GEN-LAST:event_repostBoton16MouseClicked

    private void repostBoton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton16ActionPerformed

    private void repostBoton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton17MouseClicked
        repost(17);
    }//GEN-LAST:event_repostBoton17MouseClicked

    private void repostBoton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton17ActionPerformed

    private void repostBoton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton18MouseClicked
        repost(18);
    }//GEN-LAST:event_repostBoton18MouseClicked

    private void repostBoton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton18ActionPerformed

    private void repostBoton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repostBoton19MouseClicked
        repost(19);
    }//GEN-LAST:event_repostBoton19MouseClicked

    private void repostBoton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostBoton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repostBoton19ActionPerformed

    private void commentBoton0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentBoton0MouseClicked
        ObjectId idd = null;
        String comment = "";
        if (feedOn) {
            idd = feedItemz.get(0).id;
            comment = feedItemz.get(0).comment.getText();
            feedItemz.get(0).comment.setText("");
        } else {
            idd = postItemz.get(0).id;
            comment = postItemz.get(0).comment.getText();
            postItemz.get(0).comment.setText("");
        }

        for (int i = 0; i < posties.size(); i++) {
            if (idd.equals(posties.get(i).getId())) {
                System.out.println(idd);
                Comments commentt = new Comments(idd.toString(), currentuser, comment);
                commenties.add(commentt);
                System.out.println(commenties);
                comms.insertOne(commentt);
            }
        }
    }//GEN-LAST:event_commentBoton0MouseClicked

    private void ConfigurarCuentaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfigurarCuentaButtonMouseClicked

        if (ConfigurarCuentaButton.getText().equals("Amigos de Amigos")) {
            ConfigurarCuentaButton.setText("Solamente Amigos");
            Document query = new Document().append("aemail", currentuser);
            Bson updates = Updates.combine(
                    Updates.set("config", 0));
            UpdateOptions options = new UpdateOptions().upsert(true);
            try {
                UpdateResult result = userss.updateOne(query, updates, options);
                for (int i = 0; i < usuariosss.size(); i++) {
                    if (usuariosss.get(i).getAemail().equals(currentuser) || usuariosss.get(i).getAemail() == currentuser) {
                        usuariosss.get(i).setConfig(0);
                    }
                }
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
        } else {
            ConfigurarCuentaButton.setText("Amigos de Amigos");
            Document query = new Document().append("aemail", currentuser);
            Bson updates = Updates.combine(
                    Updates.set("config", 1));

            UpdateOptions options = new UpdateOptions().upsert(true);
            try {
                UpdateResult result = userss.updateOne(query, updates, options);
                for (int i = 0; i < usuariosss.size(); i++) {
                    if (usuariosss.get(i).getAemail().equals(currentuser) || usuariosss.get(i).getAemail() == currentuser) {
                        usuariosss.get(i).setConfig(1);
                    }
                }

            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
        }
    }//GEN-LAST:event_ConfigurarCuentaButtonMouseClicked

    private void ConfigurarCuentaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfigurarCuentaButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfigurarCuentaButtonMouseEntered

    private void ConfigurarCuentaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfigurarCuentaButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfigurarCuentaButtonMouseExited

    private void ConfigurarCuentaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigurarCuentaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfigurarCuentaButtonActionPerformed

    private void posts1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posts1MouseClicked
        if (actualuwu) {
            generatePosts();
        } else {
            generatePosts2();
        }

        panelProfile.repaint();
    }//GEN-LAST:event_posts1MouseClicked

    private void posts1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posts1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_posts1MouseEntered

    private void posts1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posts1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_posts1MouseExited

    private void posts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posts1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_posts1ActionPerformed

    private void reposts2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reposts2MouseClicked
        // TODO add your handling code here:
        generateReposts();
        profileView.repaint();
    }//GEN-LAST:event_reposts2MouseClicked

    private void reposts2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reposts2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_reposts2MouseEntered

    private void reposts2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reposts2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_reposts2MouseExited

    private void reposts2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reposts2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reposts2ActionPerformed
    ArrayList<Posts> forFeedPosts = new ArrayList();

    public void mostrarcomments(int pos) {
        System.out.println("on method");

        ObjectId idd = null;
        String comment = "";
        String forComments = "";
        if (feedOn) {
            idd = feedItemz.get(pos).id;

        } else {
            idd = postItemz.get(pos).id;
        }
        System.out.println("idd on method: " + idd);
        System.out.println(commenties);
        for (int i = 0; i < commenties.size(); i++) {
            System.out.println("iddd: " + commenties.get(i).getPostid().toString());
            if (commenties.get(i).getPostid().toString().equals(idd.toString())) {
                System.out.println("entro");
                forComments += commenties.get(i).getEmail() + ": \n" + commenties.get(i).getContenido() + "\n\n";
            }
        }
        System.out.println(forComments);
        jTextArea1.setText(forComments);
        jTextArea1.repaint();

        ViewCommentsDialog.setModal(true);
        ViewCommentsDialog.pack();
        ViewCommentsDialog.setLocationRelativeTo(this);
        ViewCommentsDialog.setVisible(true);

    }

    public void generate2HRPosts() {
        forFeedPosts.clear();
        for (int i = 0; i < posties.size(); i++) {
            Date fechita = posties.get(i).getCfecha();
            int fechota = fechita.getHours();
            System.out.println(posties.get(i).getEpost());
            Date datie = new Date();
            long secs = (datie.getTime() - fechita.getTime()) / 1000;
            int hours = (int) secs / 3600;
            secs = secs % 3600;
            int mins = (int) secs / 60;
            secs = secs % 60;
            System.out.println("supuesta diferencia: " + hours);
            if (hours <= 2) {
                System.out.println("entra aqui");
                forFeedPosts.add(posties.get(i));
            }

        }
        System.out.println("size for feed: " + forFeedPosts.size());
        for (int i = 0; i < forFeedPosts.size(); i++) {
            System.out.println("post: " + forFeedPosts.get(i));
        }
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

    public void mostrarNewPost() {
        NewPostDialog.setModal(true);
        NewPostDialog.pack();
        NewPostDialog.setLocationRelativeTo(this);
        NewPostDialog.setVisible(true);
    }

    public void borders() {
        SIemail.setBorder(BorderFactory.createCompoundBorder(SIemail.getBorder(), BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        SIpass.setBorder(BorderFactory.createCompoundBorder(SIpass.getBorder(), BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        SUemail.setBorder(BorderFactory.createCompoundBorder(SUemail.getBorder(), BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        SUpass.setBorder(BorderFactory.createCompoundBorder(SUpass.getBorder(), BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        SUname.setBorder(BorderFactory.createCompoundBorder(SUname.getBorder(), BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        SUsur.setBorder(BorderFactory.createCompoundBorder(SUsur.getBorder(), BorderFactory.createEmptyBorder(6, 6, 6, 6)));
        searchBar.setBorder(BorderFactory.createCompoundBorder(searchBar.getBorder(), BorderFactory.createEmptyBorder(6, 6, 6, 6)));

        scrollFeed.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollFeed.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        profileView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        profileView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    }

    public void refresh() {
        feedOn = true;
        feedPanel.removeAll();
        feedPanel.setSize(HomePage.getWidth(), HomePage.getHeight());
        feedPanel.repaint();
        generateFeed();
        CardLayout card = (CardLayout) mainContentPanel.getLayout();
        card.show(mainContentPanel, "feedPane");
        mainContentPanel.repaint();
        scrollFeed.repaint();
        Font f = homeBoton.getFont();
        homeBoton.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        f = searchBoton.getFont();
        searchBoton.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
        f = profileBoton.getFont();
        profileBoton.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
    }

    public ImageIcon pruebaFoto(int chikito, String url) {
        jPanel3.setBackground(new Color(0, 0, 0, 0));
        ImageIcon icon2 = null;
        //File fichero = new File("C:\\Users\\HP\\OneDrive\\Desktop\\WIN_20220602_08_00_06_Pro.jpg");
        File fichero = new File(url);
        FileInputStream entrada = null;
        ObjectInputStream objeto = null;
        try {

            //fichero = jfc.getSelectedFile();
            //fichero = "C:\\Users\\HP\\OneDrive\\Desktop\\WIN_20220602_08_00_06_Pro.jpg";
            System.out.println("FICHERO: " + fichero);
            /*entrada = new FileInputStream(fichero);
                System.out.println("ENTRADA:" +entrada);
                objeto = new ObjectInputStream(entrada);
                System.out.println(objeto);*/

            BufferedImage img = ImageIO.read(new File(fichero.toString()));
            BufferedImage img2 = null;
            int size = 0;
            int hji = 0;
            int wji = 0;
            if (chikito == 0) {
                size = 40;
            } else if (chikito == 10) {
                size = 30;
            } else {
                size = fotoProfile.getWidth();
                hji = fotoBanner.getHeight();
                wji = fotoBanner.getWidth();
            }

            if (chikito == 3) {
                img2 = resize(img, wji, hji);
                icon2 = new ImageIcon(img2);
                //fotoBanner.setIcon(icon2);
            } else if (chikito == 4) {
                size = 110;
                img2 = resize(img, size, size);
                icon2 = new ImageIcon(img2);
            } else {
                img2 = resize(img, size, size);
                int width = img2.getWidth();
                BufferedImage circleBuffer = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = circleBuffer.createGraphics();
                g2.setClip(new Ellipse2D.Float(0, 0, width, width));
                g2.drawImage(img2, 0, 0, width, width, null);
                icon2 = new ImageIcon(circleBuffer);
            }

            //BufferedImage img2 = resize(img, 100,100);
            //JFrame frame = new JFrame();
            //frame.setLayout(new FlowLayout());
            //frame.setSize(200, 300);
            //JLabel lbl = new JLabel();
            //panelFoto.setIcon((Icon)img2);
            //frame.add(lbl);
            //frame.setVisible(true);
            //fin if
        } catch (Exception e) {
            e.printStackTrace();
        }
        return icon2;
    }

    class ProfileItem {

        public JPanel panelProfile;
        public JLabel pfp;
        public JLabel nameLabel;
        public JCheckBox acceptBox;
        public Color bg = new Color(40, 40, 40);
        public Color white = new Color(255, 255, 255);

        public ProfileItem(int x, int y, int largo, int alto, String email) {
            this.panelProfile = new JPanel();
            this.pfp = new JLabel("foto", SwingConstants.LEFT);
            this.nameLabel = new JLabel(email, SwingConstants.LEFT);
            this.acceptBox = new JCheckBox();

            panelProfile.setBackground(bg);
            panelProfile.setSize(largo, alto);
            panelProfile.setLayout(null);
            panelProfile.setLocation(x, y);

            panelProfile.add(pfp);
            pfp.setLocation(5, 5);
            pfp.setSize(alto - 10, alto - 10);
            pfp.setIcon(pruebaFoto(0, fichero.toString()));

            Font fontLabel = new Font("Roboto", Font.BOLD, 18);
            panelProfile.add(nameLabel);
            nameLabel.setFont(fontLabel);
            nameLabel.setForeground(white);
            nameLabel.setLocation(alto + 10, 5);
            nameLabel.setSize(largo - alto - 15 - 30, alto - 10);
            nameLabel.setBorder(null);
            nameLabel.setForeground(white);

            panelProfile.add(acceptBox);
            acceptBox.setSelected(false);
            acceptBox.setLocation(largo - 40, 0);
            //acceptBox.setLocation((alto/2) + 10, largo-50);
            acceptBox.setSize(50, 50);
            acceptBox.setBackground(bg);
            acceptBox.setForeground(white);
        }

        public JPanel getPanelProfile() {
            return panelProfile;
        }

        public void setPanelProfile(JPanel panelProfile) {
            this.panelProfile = panelProfile;
        }

        public JLabel getPfp() {
            return pfp;
        }

        public void setPfp(JLabel pfp) {
            this.pfp = pfp;
        }

        public JLabel getNameLabel() {
            return nameLabel;
        }

        public void setNameLabel(JLabel nameLabel) {
            this.nameLabel = nameLabel;
        }

        public JCheckBox getAcceptBox() {
            return acceptBox;
        }

        public void setAcceptBox(JCheckBox acceptBox) {
            this.acceptBox = acceptBox;
        }

    }

    class searchItem {

        public JPanel panelProfile;
        public JLabel pfp;
        public JLabel nameLabel;
        public JLabel emailLabel;
        public JButton profileButton;

        public searchItem(JPanel panelProfile, JLabel pfp, JLabel nameLabel, JLabel emailLabel, JButton profileButton) {
            this.panelProfile = panelProfile;
            this.pfp = pfp;
            this.nameLabel = nameLabel;
            this.emailLabel = emailLabel;
            this.profileButton = profileButton;
        }

        public void searchItemUpdate(String nombre, String apellido, String email) {
            this.panelProfile.setVisible(true);
            //this.pfp = pfp;
            this.nameLabel.setText(nombre + " " + apellido);
            this.emailLabel.setText(email);
            //this.profileButton = profileButton;
        }

        public void Disable() {
            this.panelProfile.setVisible(false);
            //this.pfp = pfp;
            //this.nameLabel.setText(nombre + " " + apellido);
            //this.emailLabel.setText(aemail);
            //this.profileButton = profileButton;
        }

    }

    class postItem {

        public JPanel panelPost;
        public JLabel pfp;
        public JLabel postPhoto;
        public JLabel nameLabel;
        public JLabel emailLabel;
        public JLabel dateLabel;
        public JTextArea postContent;
        public JTextArea comment;
        public Color bg = new Color(40, 40, 40);
        public Color bg2 = new Color(60, 60, 60);
        public Color white = new Color(255, 255, 255);
        public int alto;
        public int largo;

        @BsonProperty(value = "_id")
        ObjectId id;

        public postItem(int x, int y, int largo, int alto, String email, String name, String content, Date date, String url, String url2, ObjectId id, String time) {
            this.panelPost = new JPanel();
            this.pfp = new JLabel("", SwingConstants.LEFT);
            this.nameLabel = new JLabel(name, SwingConstants.LEFT);
            this.emailLabel = new JLabel("@" + email, SwingConstants.LEFT);
            this.dateLabel = new JLabel(date.toString(), SwingConstants.LEFT);
            this.postContent = new JTextArea(content);
            this.comment = new JTextArea("");
            this.postPhoto = new JLabel("", SwingConstants.LEFT);
            this.id = id;
            this.alto = alto;
            this.largo = largo;

            JScrollPane scroll = new JScrollPane(postContent);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            panelPost.setBackground(bg);
            panelPost.setSize(largo, alto);
            panelPost.setLayout(null);
            panelPost.setLocation(x, y);

            panelPost.add(pfp);
            pfp.setLocation(5, 5);
            pfp.setSize(30, 30);
            pfp.setIcon(pruebaFoto(10, url2));

            Font fontLabel = new Font("Roboto", Font.BOLD, 18);
            panelPost.add(nameLabel);
            nameLabel.setFont(fontLabel);
            nameLabel.setForeground(white);
            nameLabel.setLocation(40, 10);
            nameLabel.setSize(name.length() * 9, 20);
            nameLabel.setBorder(null);
            nameLabel.setBackground(IsaTheme);

            Font fontLabelMini = new Font("Roboto", Font.BOLD, 12);
            panelPost.add(emailLabel);
            emailLabel.setFont(fontLabelMini);
            emailLabel.setLocation((nameLabel.getWidth()) + 40, 10);
            emailLabel.setSize(panelPost.getWidth() - ((nameLabel.getWidth()) + 20 + 30), 20);
            emailLabel.setBorder(null);
            emailLabel.setForeground(IsaTheme);

            panelPost.add(scroll);
            scroll.setSize(panelPost.getWidth() - (panelPost.getHeight() - 50) - 30, panelPost.getHeight() - 50 - 50 - 15);
            scroll.setBorder(null);
            scroll.setLocation(10, 40);

            Font fontLabel2 = new Font("Roboto", Font.PLAIN, 16);
            //panelPost.add(postContent);
            postContent.setFont(fontLabel2);
            postContent.setForeground(white);
            postContent.setBackground(bg);
            postContent.setBorder(null);
            postContent.setLocation(0, 0);
            postContent.setSize(panelPost.getWidth() - (panelPost.getHeight() - 50) - 30, panelPost.getHeight() - 50 - 50 - 15);
            postContent.setBorder(null);
            postContent.setLineWrap(true);
            postContent.setEditable(false);

            Font fontLabel3 = new Font("Roboto", Font.PLAIN, 12);
            panelPost.add(comment);
            comment.setFont(fontLabel3);
            comment.setForeground(white);
            comment.setBackground(bg2);
            comment.setBorder(null);
            comment.setLocation(10, panelPost.getHeight() - 59);
            comment.setSize(panelPost.getWidth() - (panelPost.getHeight()) - 30 - 50 - 40, 55);
            comment.setBorder(null);
            comment.setLineWrap(true);
            comment.setEditable(true);
            comment.setBorder(BorderFactory.createCompoundBorder(comment.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

            panelPost.add(postPhoto);
            postPhoto.setLocation(panelPost.getWidth() - (panelPost.getHeight() - 50), 35);
            postPhoto.setSize(panelPost.getHeight() - 50, panelPost.getHeight() - 50);
            postPhoto.setIcon(pruebaFoto(4, url));

            Font fontDate = new Font("Roboto", Font.BOLD, 12);
            panelPost.add(dateLabel);
            dateLabel.setFont(fontDate);
            dateLabel.setForeground(IsaTheme);
            dateLabel.setLocation(15, panelPost.getHeight() - 79);
            dateLabel.setSize(postContent.getWidth(), 20);
            dateLabel.setBorder(null);

            //AQUI PONES LO DE HACE CUANTO FUE INSTEAD DEL TOSTRING
            dateLabel.setText(time);

        }

        public JPanel getPanelPost() {
            return panelPost;
        }

        public void setPanelPost(JPanel panelPost) {
            this.panelPost = panelPost;
        }

        public JLabel getPfp() {
            return pfp;
        }

        public void setPfp(JLabel pfp) {
            this.pfp = pfp;
        }

        public JLabel getNameLabel() {
            return nameLabel;
        }

        public void setNameLabel(JLabel nameLabel) {
            this.nameLabel = nameLabel;
        }

        public JLabel getEmailLabel() {
            return emailLabel;
        }

        public void setEmailLabel(JLabel emailLabel) {
            this.emailLabel = emailLabel;
        }

        public JTextArea getPostContent() {
            return postContent;
        }

        public void setPostContent(JTextArea postContent) {
            this.postContent = postContent;
        }

        public Color getBg() {
            return bg;
        }

        public void setBg(Color bg) {
            this.bg = bg;
        }

        public Color getWhite() {
            return white;
        }

        public void setWhite(Color white) {
            this.white = white;
        }

    }

    /* public void generatePosts() {
        feedPanel.removeAll();
        feedPanel.repaint();
        int height = 50;
        int initialY = 5;
        feedPanel.setPreferredSize(new Dimension(postsScroll.getWidth() - 70, HEIGHT));
        for (int i = 0; i < posties.size(); i++) {
            feedPanel.setPreferredSize(new Dimension(postsScroll.getWidth() - 70, (((height + 5) * i) + 5)));

            /* ProfileItem pim = new ProfileItem(5, initialY, newFollowPanel.getWidth() - 10, height, currentuser);
            feedPanel.add(pim.getPanelProfile());
            postsBoxes.add(pim);
            initialY += height + 5;
        }
    }*/
    public void generateFollowRequests() {
        newFollowPanel.removeAll();
        newFollowPanel.repaint();
        newFollowPanel.setPreferredSize(new Dimension(newFollowScroll.getWidth() - 70, HEIGHT));
        int height = 50;
        int initialY = 5;
        ArrayList<String> requests = new ArrayList();
        String mail = "";
        for (int i = 0; i < usuariosss.size(); i++) {
            if (currentuser.equals(usuariosss.get(i).getAemail())) {
                requests = (ArrayList<String>) usuariosss.get(i).getHrequests();
            }
        }

        for (int i = 0; i < requests.size(); i++) {
            String email = requests.get(i);
            for (int j = 0; j < usuariosss.size(); j++) {
                if (email.equals(usuariosss.get(j).getAemail())) {
                    mail = usuariosss.get(j).getAemail();
                    newFollowPanel.setPreferredSize(new Dimension(newFollowScroll.getWidth() - 70, (((height + 5) * i) + 5)));
                    ProfileItem pim = new ProfileItem(5, initialY, newFollowPanel.getWidth() - 10, height, mail);
                    newFollowPanel.add(pim.getPanelProfile());
                    followRequests.add(pim);
                    initialY += height + 5;
                }
            }
        }

        //newFollowPanel
        /*ProfileItem pim = new ProfileItem(5,5,200,100);
        newFollowPanel.add(pim.getPanelProfile());*/
    }

    //CLASS QUE INTENTE USAR PARA ROUNDED BORDER PERO USES GRAPHICS AND I DONT LIKE THAT
    /*private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }*/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    //COLORES NO IMPORTANTES
    Color colorAbierto = new Color(204, 255, 204);
    Color colorCerrado = new Color(255, 153, 153);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfigurarCuentaButton;
    private javax.swing.JPanel HomePage;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JDialog NewPostDialog;
    private javax.swing.JButton SIboton;
    private javax.swing.JButton SIboton1;
    private javax.swing.JTextField SIemail;
    private javax.swing.JPasswordField SIpass;
    private com.toedter.calendar.JDateChooser SUbd;
    private javax.swing.JLabel SUboton;
    private javax.swing.JLabel SUboton1;
    private javax.swing.JTextField SUemail;
    private javax.swing.JTextField SUname;
    private javax.swing.JPasswordField SUpass;
    private javax.swing.JTextField SUsur;
    private javax.swing.JPanel SignInPanel;
    private javax.swing.JButton SignUpBoton;
    private javax.swing.JPanel SignUpPanel;
    private javax.swing.JDialog ViewCommentsDialog;
    private javax.swing.JButton commentBoton0;
    private javax.swing.JButton commentBoton1;
    private javax.swing.JButton commentBoton10;
    private javax.swing.JButton commentBoton11;
    private javax.swing.JButton commentBoton12;
    private javax.swing.JButton commentBoton13;
    private javax.swing.JButton commentBoton14;
    private javax.swing.JButton commentBoton15;
    private javax.swing.JButton commentBoton16;
    private javax.swing.JButton commentBoton17;
    private javax.swing.JButton commentBoton18;
    private javax.swing.JButton commentBoton19;
    private javax.swing.JButton commentBoton2;
    private javax.swing.JButton commentBoton3;
    private javax.swing.JButton commentBoton4;
    private javax.swing.JButton commentBoton5;
    private javax.swing.JButton commentBoton6;
    private javax.swing.JButton commentBoton7;
    private javax.swing.JButton commentBoton8;
    private javax.swing.JButton commentBoton9;
    private javax.swing.JPanel feedPanel;
    private javax.swing.JLabel fotoBanner;
    private javax.swing.JLabel fotoProfile;
    private javax.swing.JLabel homeBoton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JPanel mainContentPanel;
    private javax.swing.JButton newBio;
    private javax.swing.JButton newBio1;
    private javax.swing.JPanel newFollowPanel;
    private javax.swing.JScrollPane newFollowScroll;
    private javax.swing.JButton newTweet;
    private javax.swing.JButton newTweet1;
    private javax.swing.JButton newTweet2;
    private javax.swing.JButton newTweet3;
    private javax.swing.JLabel panelFoto;
    private javax.swing.JPanel panelIMG;
    private javax.swing.JPanel panelProfile;
    private javax.swing.JButton posts1;
    private javax.swing.JLabel profileBoton;
    private javax.swing.JPanel profileSearch0;
    private javax.swing.JPanel profileSearch1;
    private javax.swing.JPanel profileSearch2;
    private javax.swing.JPanel profileSearch3;
    private javax.swing.JPanel profileSearch4;
    private javax.swing.JPanel profileSearch5;
    private javax.swing.JPanel profileSearch6;
    private javax.swing.JPanel profileSearch7;
    private javax.swing.JPanel profileSearch8;
    private javax.swing.JScrollPane profileView;
    private javax.swing.JLabel refreshBoton;
    private javax.swing.JButton repostBoton0;
    private javax.swing.JButton repostBoton1;
    private javax.swing.JButton repostBoton10;
    private javax.swing.JButton repostBoton11;
    private javax.swing.JButton repostBoton12;
    private javax.swing.JButton repostBoton13;
    private javax.swing.JButton repostBoton14;
    private javax.swing.JButton repostBoton15;
    private javax.swing.JButton repostBoton16;
    private javax.swing.JButton repostBoton17;
    private javax.swing.JButton repostBoton18;
    private javax.swing.JButton repostBoton19;
    private javax.swing.JButton repostBoton2;
    private javax.swing.JButton repostBoton3;
    private javax.swing.JButton repostBoton4;
    private javax.swing.JButton repostBoton5;
    private javax.swing.JButton repostBoton6;
    private javax.swing.JButton repostBoton7;
    private javax.swing.JButton repostBoton8;
    private javax.swing.JButton repostBoton9;
    private javax.swing.JButton reposts2;
    private javax.swing.JScrollPane scrollFeed;
    private javax.swing.JTextField searchBar;
    private javax.swing.JLabel searchBoton;
    private javax.swing.JButton searchBoton0;
    private javax.swing.JLabel searchBoton1;
    private javax.swing.JButton searchBoton2;
    private javax.swing.JButton searchBoton3;
    private javax.swing.JButton searchBoton4;
    private javax.swing.JButton searchBoton5;
    private javax.swing.JButton searchBoton6;
    private javax.swing.JButton searchBoton7;
    private javax.swing.JButton searchBoton8;
    private javax.swing.JButton searchBoton9;
    private javax.swing.JLabel searchEmail0;
    private javax.swing.JLabel searchEmail1;
    private javax.swing.JLabel searchEmail2;
    private javax.swing.JLabel searchEmail3;
    private javax.swing.JLabel searchEmail4;
    private javax.swing.JLabel searchEmail5;
    private javax.swing.JLabel searchEmail6;
    private javax.swing.JLabel searchEmail7;
    private javax.swing.JLabel searchEmail8;
    private javax.swing.JLabel searchFoto0;
    private javax.swing.JLabel searchFoto1;
    private javax.swing.JLabel searchFoto2;
    private javax.swing.JLabel searchFoto3;
    private javax.swing.JLabel searchFoto4;
    private javax.swing.JLabel searchFoto5;
    private javax.swing.JLabel searchFoto6;
    private javax.swing.JLabel searchFoto7;
    private javax.swing.JLabel searchFoto8;
    private javax.swing.JLabel searchNombre0;
    private javax.swing.JLabel searchNombre1;
    private javax.swing.JLabel searchNombre2;
    private javax.swing.JLabel searchNombre3;
    private javax.swing.JLabel searchNombre4;
    private javax.swing.JLabel searchNombre5;
    private javax.swing.JLabel searchNombre6;
    private javax.swing.JLabel searchNombre7;
    private javax.swing.JLabel searchNombre8;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel signOutBoton;
    private javax.swing.JTextArea textPostJT;
    private javax.swing.JButton vercommentBoton0;
    private javax.swing.JButton vercommentBoton1;
    private javax.swing.JButton vercommentBoton10;
    private javax.swing.JButton vercommentBoton11;
    private javax.swing.JButton vercommentBoton12;
    private javax.swing.JButton vercommentBoton13;
    private javax.swing.JButton vercommentBoton14;
    private javax.swing.JButton vercommentBoton15;
    private javax.swing.JButton vercommentBoton16;
    private javax.swing.JButton vercommentBoton17;
    private javax.swing.JButton vercommentBoton18;
    private javax.swing.JButton vercommentBoton19;
    private javax.swing.JButton vercommentBoton2;
    private javax.swing.JButton vercommentBoton3;
    private javax.swing.JButton vercommentBoton4;
    private javax.swing.JButton vercommentBoton5;
    private javax.swing.JButton vercommentBoton6;
    private javax.swing.JButton vercommentBoton7;
    private javax.swing.JButton vercommentBoton8;
    private javax.swing.JButton vercommentBoton9;
    // End of variables declaration//GEN-END:variables
}
