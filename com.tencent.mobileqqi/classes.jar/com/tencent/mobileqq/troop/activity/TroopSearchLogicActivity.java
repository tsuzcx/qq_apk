package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import gup;
import guq;

public class TroopSearchLogicActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static final long a = 300L;
  public static final String a = "type";
  public static final int b = 2;
  public static final String b = "key_words";
  public static final int c = 1;
  public static final String c = "key_troopUin";
  public Handler a;
  public TroopHandler a;
  public TroopObserver a;
  public QQProgressDialog a;
  public int d;
  public String d;
  
  public TroopSearchLogicActivity()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gup(this);
    this.jdField_a_of_type_AndroidOsHandler = new guq(this);
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Int = paramInt1;
    if (this.jdField_d_of_type_JavaLangString.trim().equals(""))
    {
      b(2131562631);
      finish();
      return false;
    }
    if (!NetworkUtil.e(this))
    {
      b(2131562449);
      finish();
      return false;
    }
    a(paramInt2);
    if (this.b == null)
    {
      finish();
      return false;
    }
    this.b.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    try
    {
      long l = Long.parseLong(this.b.a());
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, 0, 1, this.jdField_d_of_type_JavaLangString, 1, 0L);
      return true;
    }
    catch (Exception paramString)
    {
      finish();
    }
    return false;
  }
  
  /* Error */
  public java.lang.Boolean a(String paramString)
  {
    // Byte code:
    //   0: new 105	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 108	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: ldc 110
    //   14: invokevirtual 114	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload 4
    //   20: ldc 116
    //   22: invokevirtual 114	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 122	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   28: istore_2
    //   29: aload_1
    //   30: ifnull +20 -> 50
    //   33: ldc 57
    //   35: aload_1
    //   36: invokevirtual 61	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifne +11 -> 50
    //   42: aload_1
    //   43: invokevirtual 126	java/lang/String:length	()I
    //   46: iconst_5
    //   47: if_icmpge +12 -> 59
    //   50: aload_0
    //   51: invokevirtual 68	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   54: iconst_0
    //   55: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   58: areturn
    //   59: aload_0
    //   60: aload_1
    //   61: iload_2
    //   62: ldc 133
    //   64: invokespecial 135	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:a	(Ljava/lang/String;II)Z
    //   67: istore_3
    //   68: iload_3
    //   69: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   72: areturn
    //   73: astore_1
    //   74: aload_0
    //   75: invokevirtual 68	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   78: iconst_0
    //   79: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   82: areturn
    //   83: astore_1
    //   84: aload_0
    //   85: invokevirtual 68	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   88: iconst_0
    //   89: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   92: areturn
    //   93: astore 4
    //   95: iconst_0
    //   96: istore_2
    //   97: goto -68 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	TroopSearchLogicActivity
    //   0	100	1	paramString	String
    //   28	69	2	i	int
    //   67	2	3	bool	boolean
    //   8	11	4	localJSONObject	org.json.JSONObject
    //   93	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	18	73	org/json/JSONException
    //   18	29	73	org/json/JSONException
    //   33	50	73	org/json/JSONException
    //   50	59	73	org/json/JSONException
    //   59	68	73	org/json/JSONException
    //   0	10	83	org/json/JSONException
    //   74	78	83	org/json/JSONException
    //   18	29	93	java/lang/Exception
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: new 105	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 108	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: ldc 151
    //   14: invokevirtual 114	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload 4
    //   20: ldc 116
    //   22: invokevirtual 114	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 122	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   28: istore_2
    //   29: aload_0
    //   30: aload_1
    //   31: iload_2
    //   32: ldc 152
    //   34: invokespecial 135	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:a	(Ljava/lang/String;II)Z
    //   37: istore_3
    //   38: iload_3
    //   39: ireturn
    //   40: astore 4
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -15 -> 29
    //   47: astore_1
    //   48: aload_0
    //   49: invokevirtual 68	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   52: iconst_0
    //   53: ireturn
    //   54: astore_1
    //   55: aload_0
    //   56: invokevirtual 68	com/tencent/mobileqq/troop/activity/TroopSearchLogicActivity:finish	()V
    //   59: iconst_0
    //   60: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	TroopSearchLogicActivity
    //   0	61	1	paramString	String
    //   28	16	2	i	int
    //   37	2	3	bool	boolean
    //   8	11	4	localJSONObject	org.json.JSONObject
    //   40	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   18	29	40	java/lang/Exception
    //   10	18	47	org/json/JSONException
    //   18	29	47	org/json/JSONException
    //   29	38	47	org/json/JSONException
    //   0	10	54	org/json/JSONException
    //   48	52	54	org/json/JSONException
  }
  
  public final void b(int paramInt)
  {
    QQToast.a(this, paramInt, 0).b(d());
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("type", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.b.a(19));
    if (i == 2)
    {
      a(paramBundle.getStringExtra("key_words"));
      return true;
    }
    if (i == 1)
    {
      a(paramBundle.getStringExtra("key_words"));
      return true;
    }
    finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopSearchLogicActivity
 * JD-Core Version:    0.7.0.1
 */