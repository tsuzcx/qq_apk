package com.dataline.mpfile;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.dataline.activities.LiteActivity;
import com.dataline.util.HttpUpload;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import cx;
import cy;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LiteMpFileActionListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, Observer
{
  public static int a = 0;
  public static String a;
  public static ArrayList a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 101;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cx(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MpfileFileListAdapter jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter;
  public HttpUpload a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString = "http://%s:%d/qqmpfile/?action=fileList&offset=0&limit=100";
  private Button c;
  private Button d;
  int l = 55;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public LiteMpFileActionListActivity()
  {
    this.jdField_a_of_type_ComDatalineUtilHttpUpload = new HttpUpload();
  }
  
  /* Error */
  private String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: aload_1
    //   8: ifnull +12 -> 20
    //   11: aload_1
    //   12: invokevirtual 89	java/io/File:exists	()Z
    //   15: ifne +7 -> 22
    //   18: aload_3
    //   19: astore_2
    //   20: aload_2
    //   21: areturn
    //   22: new 91	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   29: astore_3
    //   30: new 94	java/io/BufferedReader
    //   33: dup
    //   34: new 96	java/io/FileReader
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 99	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   42: invokespecial 102	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_2
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 106	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 5
    //   54: aload 5
    //   56: ifnull +71 -> 127
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: aload 5
    //   64: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto -22 -> 46
    //   71: astore_3
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 113	java/io/FileNotFoundException:printStackTrace	()V
    //   78: aload 4
    //   80: astore_1
    //   81: aload_2
    //   82: ifnull +10 -> 92
    //   85: aload_2
    //   86: invokevirtual 116	java/io/BufferedReader:close	()V
    //   89: aload 4
    //   91: astore_1
    //   92: aload_1
    //   93: astore_2
    //   94: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq -77 -> 20
    //   100: ldc 123
    //   102: iconst_2
    //   103: new 91	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   110: ldc 125
    //   112: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_1
    //   126: areturn
    //   127: aload_2
    //   128: astore_1
    //   129: aload_2
    //   130: invokevirtual 116	java/io/BufferedReader:close	()V
    //   133: aload_2
    //   134: astore_1
    //   135: aload_3
    //   136: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore_3
    //   140: aload_3
    //   141: astore_1
    //   142: aload_2
    //   143: ifnull -51 -> 92
    //   146: aload_2
    //   147: invokevirtual 116	java/io/BufferedReader:close	()V
    //   150: aload_3
    //   151: astore_1
    //   152: goto -60 -> 92
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   160: aload_3
    //   161: astore_1
    //   162: goto -70 -> 92
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   170: aload 4
    //   172: astore_1
    //   173: goto -81 -> 92
    //   176: astore_3
    //   177: aconst_null
    //   178: astore_2
    //   179: aload_2
    //   180: astore_1
    //   181: aload_3
    //   182: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   185: aload 4
    //   187: astore_1
    //   188: aload_2
    //   189: ifnull -97 -> 92
    //   192: aload_2
    //   193: invokevirtual 116	java/io/BufferedReader:close	()V
    //   196: aload 4
    //   198: astore_1
    //   199: goto -107 -> 92
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   207: aload 4
    //   209: astore_1
    //   210: goto -118 -> 92
    //   213: astore_2
    //   214: aconst_null
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 116	java/io/BufferedReader:close	()V
    //   224: aload_2
    //   225: athrow
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   231: goto -7 -> 224
    //   234: astore_2
    //   235: goto -19 -> 216
    //   238: astore_3
    //   239: goto -60 -> 179
    //   242: astore_3
    //   243: aconst_null
    //   244: astore_2
    //   245: goto -173 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	LiteMpFileActionListActivity
    //   0	248	1	paramFile	java.io.File
    //   6	187	2	localObject1	Object
    //   213	12	2	localObject2	Object
    //   234	1	2	localObject3	Object
    //   244	1	2	localObject4	Object
    //   4	58	3	localStringBuilder	java.lang.StringBuilder
    //   71	65	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   139	22	3	str1	String
    //   176	6	3	localIOException1	java.io.IOException
    //   238	1	3	localIOException2	java.io.IOException
    //   242	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	207	4	localObject5	Object
    //   52	11	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   48	54	71	java/io/FileNotFoundException
    //   61	68	71	java/io/FileNotFoundException
    //   129	133	71	java/io/FileNotFoundException
    //   135	140	71	java/io/FileNotFoundException
    //   146	150	155	java/io/IOException
    //   85	89	165	java/io/IOException
    //   22	46	176	java/io/IOException
    //   192	196	202	java/io/IOException
    //   22	46	213	finally
    //   220	224	226	java/io/IOException
    //   48	54	234	finally
    //   61	68	234	finally
    //   74	78	234	finally
    //   129	133	234	finally
    //   135	140	234	finally
    //   181	185	234	finally
    //   48	54	238	java/io/IOException
    //   61	68	238	java/io/IOException
    //   129	133	238	java/io/IOException
    //   135	140	238	java/io/IOException
    //   22	46	242	java/io/FileNotFoundException
  }
  
  private void d() {}
  
  private void e()
  {
    setTitle(2131558536);
    this.m.setVisibility(4);
    String str = this.k.getText().toString();
    if (str.contains(getString(2131561807)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView = this.k;
      f();
    }
    do
    {
      return;
      if (str.contains(getString(2131561870)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView = this.k;
        this.jdField_a_of_type_AndroidWidgetTextView = this.k;
        f();
        return;
      }
    } while (!str.contains(getString(2131558673)));
  }
  
  private void f()
  {
    int m;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localQQMessageFacade != null)
      {
        m = localQQMessageFacade.f();
        if (m <= 0) {
          break label107;
        }
        if (m <= 99) {
          break label66;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(99+)");
      }
    }
    return;
    label66:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(" + m + ")");
    return;
    label107:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131561807));
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 63	com/dataline/mpfile/LiteMpFileActionListActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6: astore_1
    //   7: new 203	java/net/URL
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 206	java/net/URL:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 210	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: checkcast 212	java/net/HttpURLConnection
    //   21: astore_1
    //   22: new 214	java/io/InputStreamReader
    //   25: dup
    //   26: aload_1
    //   27: invokevirtual 218	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   30: invokespecial 221	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   33: astore_3
    //   34: new 94	java/io/BufferedReader
    //   37: dup
    //   38: aload_3
    //   39: invokespecial 102	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_2
    //   43: new 223	java/lang/StringBuffer
    //   46: dup
    //   47: invokespecial 224	java/lang/StringBuffer:<init>	()V
    //   50: astore 4
    //   52: aload_2
    //   53: invokevirtual 106	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 5
    //   58: aload 5
    //   60: ifnull +45 -> 105
    //   63: aload 4
    //   65: aload 5
    //   67: invokevirtual 227	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   70: pop
    //   71: goto -19 -> 52
    //   74: astore 4
    //   76: aload_1
    //   77: astore_2
    //   78: aload_3
    //   79: astore_1
    //   80: aload 4
    //   82: astore_3
    //   83: aload_3
    //   84: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 231	java/net/HttpURLConnection:disconnect	()V
    //   95: aload_1
    //   96: ifnull +124 -> 220
    //   99: aload_1
    //   100: invokevirtual 232	java/io/InputStreamReader:close	()V
    //   103: aconst_null
    //   104: areturn
    //   105: aload 4
    //   107: invokevirtual 233	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   110: astore_2
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 231	java/net/HttpURLConnection:disconnect	()V
    //   119: aload_3
    //   120: ifnull +102 -> 222
    //   123: aload_3
    //   124: invokevirtual 232	java/io/InputStreamReader:close	()V
    //   127: aload_2
    //   128: areturn
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   134: aload_2
    //   135: areturn
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 231	java/net/HttpURLConnection:disconnect	()V
    //   154: aload_3
    //   155: ifnull +7 -> 162
    //   158: aload_3
    //   159: invokevirtual 232	java/io/InputStreamReader:close	()V
    //   162: aload_1
    //   163: athrow
    //   164: astore_2
    //   165: aload_2
    //   166: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   169: goto -7 -> 162
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: aload 4
    //   180: astore_1
    //   181: goto -35 -> 146
    //   184: astore 4
    //   186: aload_1
    //   187: astore_2
    //   188: aload 4
    //   190: astore_1
    //   191: goto -45 -> 146
    //   194: astore 4
    //   196: aload_1
    //   197: astore_3
    //   198: aload 4
    //   200: astore_1
    //   201: goto -55 -> 146
    //   204: astore_3
    //   205: aconst_null
    //   206: astore_1
    //   207: aconst_null
    //   208: astore_2
    //   209: goto -126 -> 83
    //   212: astore_3
    //   213: aload_1
    //   214: astore_2
    //   215: aconst_null
    //   216: astore_1
    //   217: goto -134 -> 83
    //   220: aconst_null
    //   221: areturn
    //   222: aload_2
    //   223: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	LiteMpFileActionListActivity
    //   6	110	1	localObject1	Object
    //   129	2	1	localIOException1	java.io.IOException
    //   136	2	1	localIOException2	java.io.IOException
    //   143	34	1	localObject2	Object
    //   180	37	1	localObject3	Object
    //   1	150	2	localObject4	Object
    //   164	2	2	localIOException3	java.io.IOException
    //   177	46	2	localObject5	Object
    //   33	165	3	localObject6	Object
    //   204	1	3	localException1	java.lang.Exception
    //   212	1	3	localException2	java.lang.Exception
    //   50	14	4	localStringBuffer	java.lang.StringBuffer
    //   74	32	4	localException3	java.lang.Exception
    //   172	7	4	localObject7	Object
    //   184	5	4	localObject8	Object
    //   194	5	4	localObject9	Object
    //   56	10	5	str	String
    // Exception table:
    //   from	to	target	type
    //   34	52	74	java/lang/Exception
    //   52	58	74	java/lang/Exception
    //   63	71	74	java/lang/Exception
    //   105	111	74	java/lang/Exception
    //   123	127	129	java/io/IOException
    //   99	103	136	java/io/IOException
    //   7	22	143	finally
    //   158	162	164	java/io/IOException
    //   22	34	172	finally
    //   34	52	184	finally
    //   52	58	184	finally
    //   63	71	184	finally
    //   105	111	184	finally
    //   83	87	194	finally
    //   7	22	204	java/lang/Exception
    //   22	34	212	java/lang/Exception
  }
  
  void a()
  {
    Intent localIntent = new Intent(this, SendPhotoActivity.class);
    localIntent.setClass(this, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 50);
    localIntent.putExtra(AlbumConstants.i, this.l);
    localIntent.putExtra("uin", AppConstants.P);
    localIntent.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.getExtras().remove("forward_type");
    startActivity(localIntent);
    AlbumUtil.a(this, false, true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramInt2 != -1);
          return;
        } while (paramInt2 != -1);
        paramInt1 = jdField_a_of_type_JavaUtilArrayList.size();
        Toast.makeText(this, String.format(getString(2131559622), new Object[] { Integer.valueOf(paramInt1) }), 0).show();
        return;
      } while (paramInt2 != -1);
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      paramView = new Intent(getApplicationContext(), FMLocalFileActivity.class);
      paramView.putExtra("category", 6);
      paramView.putExtra("selectMode", true);
      paramView.putExtra("targetUin", AppConstants.P);
      paramView.putExtra("peerType", 6);
      startActivityForResult(paramView, 2);
    }
    do
    {
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        a();
        return;
      }
      if (paramView == this.c)
      {
        startActivity(new Intent(this, LiteMpFileDownloadActivity.class));
        return;
      }
    } while (paramView != this.d);
    startActivity(new Intent(this, LiteMpFileUploadActivity.class));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903517);
    setTitle(getString(2131559621));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232793));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131232794));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.d = ((Button)findViewById(2131232795));
    this.c = ((Button)findViewById(2131232796));
    this.d.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  protected void onStart()
  {
    super.onStart();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new cy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileActionListActivity
 * JD-Core Version:    0.7.0.1
 */