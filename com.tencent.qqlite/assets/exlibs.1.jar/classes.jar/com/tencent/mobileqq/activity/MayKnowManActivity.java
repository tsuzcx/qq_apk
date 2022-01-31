package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ave;
import avf;
import avg;
import avj;
import avk;
import avm;
import cannon.Visitor;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class MayKnowManActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  static final int jdField_a_of_type_Int = 30000;
  public static final String a;
  static final int jdField_b_of_type_Int = 10;
  private static final String jdField_b_of_type_JavaLangString = "_may_known";
  public Dialog a;
  public View a;
  public LinearLayout a;
  public TextView a;
  public avm a;
  private LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new avg(this);
  public XListView a;
  public List a;
  public boolean a;
  public TextView b;
  public int c = 1;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = MayKnowManActivity.class.getSimpleName();
  }
  
  public MayKnowManActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  /* Error */
  public static List a(com.tencent.mobileqq.app.BaseActivity paramBaseActivity, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 81	java/io/ObjectInputStream
    //   5: dup
    //   6: aload_0
    //   7: new 83	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   14: aload_1
    //   15: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 14
    //   20: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 90
    //   25: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokevirtual 99	com/tencent/mobileqq/app/BaseActivity:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   34: invokespecial 102	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_2
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: invokevirtual 106	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   44: checkcast 108	java/util/List
    //   47: astore_3
    //   48: aload_2
    //   49: ifnull +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 111	java/io/ObjectInputStream:close	()V
    //   56: aload_3
    //   57: astore_1
    //   58: aload_0
    //   59: getfield 115	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   62: bipush 8
    //   64: invokevirtual 121	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   67: checkcast 123	com/tencent/mobileqq/app/FriendsManagerImp
    //   70: astore_0
    //   71: aload_1
    //   72: ifnull +132 -> 204
    //   75: aload_0
    //   76: ifnull +128 -> 204
    //   79: aload_1
    //   80: invokeinterface 127 1 0
    //   85: astore_2
    //   86: aload_2
    //   87: invokeinterface 133 1 0
    //   92: ifeq +112 -> 204
    //   95: aload_0
    //   96: new 83	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   103: aload_2
    //   104: invokeinterface 136 1 0
    //   109: checkcast 138	cannon/Visitor
    //   112: getfield 142	cannon/Visitor:uin	J
    //   115: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   118: ldc 147
    //   120: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 150	com/tencent/mobileqq/app/FriendsManagerImp:b	(Ljava/lang/String;)Z
    //   129: ifeq -43 -> 86
    //   132: aload_2
    //   133: invokeinterface 153 1 0
    //   138: goto -52 -> 86
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   146: aload_3
    //   147: astore_1
    //   148: goto -90 -> 58
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_2
    //   155: astore_1
    //   156: aload_3
    //   157: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 111	java/io/ObjectInputStream:close	()V
    //   168: aconst_null
    //   169: astore_1
    //   170: goto -112 -> 58
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   178: aconst_null
    //   179: astore_1
    //   180: goto -122 -> 58
    //   183: astore_0
    //   184: aload_3
    //   185: astore_1
    //   186: aload_1
    //   187: ifnull +7 -> 194
    //   190: aload_1
    //   191: invokevirtual 111	java/io/ObjectInputStream:close	()V
    //   194: aload_0
    //   195: athrow
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   201: goto -7 -> 194
    //   204: aload_1
    //   205: areturn
    //   206: astore_0
    //   207: goto -21 -> 186
    //   210: astore_3
    //   211: goto -57 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramBaseActivity	com.tencent.mobileqq.app.BaseActivity
    //   0	214	1	paramString	String
    //   37	128	2	localObject	Object
    //   1	146	3	localList	List
    //   151	34	3	localException1	java.lang.Exception
    //   210	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   52	56	141	java/io/IOException
    //   2	38	151	java/lang/Exception
    //   164	168	173	java/io/IOException
    //   2	38	183	finally
    //   190	194	196	java/io/IOException
    //   40	48	206	finally
    //   156	160	206	finally
    //   40	48	210	java/lang/Exception
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, MayKnowManActivity.class));
  }
  
  /* Error */
  public static void a(Context paramContext, List paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 172	java/io/ObjectOutputStream
    //   5: dup
    //   6: aload_0
    //   7: new 83	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   14: aload_2
    //   15: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 14
    //   20: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 90
    //   25: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: iconst_0
    //   32: invokevirtual 176	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   35: invokespecial 179	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   38: astore_2
    //   39: aload_2
    //   40: astore_0
    //   41: aload_2
    //   42: aload_1
    //   43: invokevirtual 183	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   46: aload_2
    //   47: astore_0
    //   48: aload_2
    //   49: invokevirtual 186	java/io/ObjectOutputStream:flush	()V
    //   52: aload_2
    //   53: ifnull +7 -> 60
    //   56: aload_2
    //   57: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   60: return
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   66: return
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: aload_3
    //   73: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   76: aload_1
    //   77: ifnull -17 -> 60
    //   80: aload_1
    //   81: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   84: return
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   90: return
    //   91: astore_0
    //   92: aload_3
    //   93: astore_1
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   102: aload_0
    //   103: athrow
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   109: goto -7 -> 102
    //   112: astore_2
    //   113: aload_0
    //   114: astore_1
    //   115: aload_2
    //   116: astore_0
    //   117: goto -23 -> 94
    //   120: astore_3
    //   121: aload_2
    //   122: astore_1
    //   123: goto -53 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramContext	Context
    //   0	126	1	paramList	List
    //   0	126	2	paramString	String
    //   1	1	3	localObject	Object
    //   67	26	3	localException1	java.lang.Exception
    //   120	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   56	60	61	java/io/IOException
    //   2	39	67	java/lang/Exception
    //   80	84	85	java/io/IOException
    //   2	39	91	finally
    //   98	102	104	java/io/IOException
    //   41	46	112	finally
    //   48	52	112	finally
    //   72	76	112	finally
    //   41	46	120	java/lang/Exception
    //   48	52	120	java/lang/Exception
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.e(this.app.getApplication()))
    {
      QQToast.a(this.app.getApplication(), 2131362923, 0).b(getTitleBarHeight());
      return false;
    }
    ((LBSHandler)this.app.a(3)).a(paramInt1, paramInt2);
    return true;
  }
  
  private void e()
  {
    int i = (int)DisplayUtils.a(this, 8.0F);
    ((RelativeLayout.LayoutParams)this.i.getLayoutParams()).setMargins(i, 0, i, 0);
    setTitle(2131363224);
    View localView = findViewById(2131297294);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131297296));
    this.b = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297297));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131297295));
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903239, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297311));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363206);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new avf(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
  }
  
  private void f()
  {
    d();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, this.d);
    localQQProgressDialog.a(getString(2131363786));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new avj(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new avk(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_Avm != null) {
      this.jdField_a_of_type_Avm.notifyDataSetChanged();
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView) {
      if (this.jdField_a_of_type_Boolean) {
        c();
      }
    }
    while ((paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return;
    }
    Object localObject = (Visitor)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramAdapterView = (FriendManager)this.app.getManager(8);
    localObject = String.valueOf(((Visitor)localObject).uin);
    if (paramAdapterView.b((String)localObject)) {}
    for (paramAdapterView = new ProfileActivity.AllInOne((String)localObject, 1);; paramAdapterView = new ProfileActivity.AllInOne((String)localObject, 4))
    {
      paramAdapterView.g = 64;
      paramView = (TextView)paramView.findViewById(16908308);
      if (paramView != null) {
        paramAdapterView.h = paramView.getText().toString();
      }
      ProfileActivity.b(this, paramAdapterView);
      return;
    }
  }
  
  protected boolean a()
  {
    finish();
    return false;
  }
  
  public void c()
  {
    int i = this.c + 1;
    this.c = i;
    if (a(10, i))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131363225);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131296561);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297310);
      localProgressBar.setVisibility(0);
      localImageView.setVisibility(8);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = getResources().getDimensionPixelSize(2131492887);
    setContentView(2130903232);
    d(2130837660);
    e();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    runOnUiThread(new ave(this));
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ProgressDialog localProgressDialog = null;
    if (paramInt == 0) {
      localProgressDialog = DialogUtil.a(this, 2131362825);
    }
    return localProgressDialog;
  }
  
  protected void onDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_Avm != null) {
      this.jdField_a_of_type_Avm.b();
    }
    super.onDestroy();
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MayKnowManActivity
 * JD-Core Version:    0.7.0.1
 */