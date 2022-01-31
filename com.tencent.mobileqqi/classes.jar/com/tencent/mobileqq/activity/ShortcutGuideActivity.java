package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import mqq.app.AppActivity;

public class ShortcutGuideActivity
  extends AppActivity
  implements View.OnClickListener
{
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  private Bitmap a()
  {
    Object localObject2 = b();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = c();
    }
    if (localObject1 == null)
    {
      localObject2 = getAppRuntime();
      if ((localObject2 != null) && ((localObject2 instanceof QQAppInterface))) {
        localObject1 = ((QQAppInterface)localObject2).a(getIntent().getStringExtra("uin"), (byte)3, true);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        int i = getResources().getDimensionPixelSize(2131427378);
        localObject2 = ImageUtil.a((Bitmap)localObject1, i, i);
        this.b = true;
      }
      return localObject2;
    }
  }
  
  private static Bitmap a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 0) {
      return BitmapManager.a(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return null;
  }
  
  private void a()
  {
    findViewById(2131233162).setOnClickListener(this);
    findViewById(2131233163).setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(d());
    }
    findViewById(2131231465).setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    Object localObject = a();
    if (localObject != null) {
      ((ImageView)findViewById(2131233160)).setImageBitmap((Bitmap)localObject);
    }
    for (;;)
    {
      localObject = getIntent().getStringExtra("uinname");
      if (localObject != null) {
        ((TextView)findViewById(2131233161)).setText((CharSequence)localObject);
      }
      return;
      ((ImageView)findViewById(2131233160)).setImageResource(2130838018);
    }
  }
  
  private boolean a(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = ViewConfiguration.get(paramActivity).getScaledWindowTouchSlop();
    paramActivity = paramActivity.getWindow().getDecorView();
    return (i < -k) || (j < -k) || (i > paramActivity.getWidth() + k) || (j > paramActivity.getHeight() + k);
  }
  
  private Bitmap b()
  {
    String str = QQAppInterface.a(getIntent().getStringExtra("uin"));
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    return BitmapManager.a(str, localOptions);
  }
  
  /* Error */
  private Bitmap c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 36	com/tencent/mobileqq/activity/ShortcutGuideActivity:getIntent	()Landroid/content/Intent;
    //   6: ldc 108
    //   8: invokevirtual 44	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 19	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: ifnonnull +24 -> 40
    //   19: aload_0
    //   20: aload_0
    //   21: ldc 179
    //   23: invokestatic 184	com/tencent/mobileqq/utils/QQUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   26: putfield 19	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: aload_0
    //   30: getfield 19	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: ifnonnull +7 -> 40
    //   36: aconst_null
    //   37: astore_2
    //   38: aload_2
    //   39: areturn
    //   40: new 186	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   47: ldc 189
    //   49: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 19	com/tencent/mobileqq/activity/ShortcutGuideActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 195
    //   61: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_0
    //   69: invokevirtual 203	com/tencent/mobileqq/activity/ShortcutGuideActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   72: astore 4
    //   74: aload 4
    //   76: aload_3
    //   77: invokestatic 209	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   80: iconst_1
    //   81: anewarray 211	java/lang/String
    //   84: dup
    //   85: iconst_0
    //   86: ldc 213
    //   88: aastore
    //   89: ldc 215
    //   91: iconst_1
    //   92: anewarray 211	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: aastore
    //   99: aconst_null
    //   100: invokevirtual 221	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +43 -> 148
    //   108: aload_1
    //   109: invokeinterface 227 1 0
    //   114: ifeq +87 -> 201
    //   117: aload_1
    //   118: iconst_0
    //   119: invokeinterface 231 2 0
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull +22 -> 148
    //   129: aload_2
    //   130: invokestatic 233	com/tencent/mobileqq/activity/ShortcutGuideActivity:a	([B)Landroid/graphics/Bitmap;
    //   133: astore_3
    //   134: aload_3
    //   135: astore_2
    //   136: aload_1
    //   137: ifnull -99 -> 38
    //   140: aload_1
    //   141: invokeinterface 236 1 0
    //   146: aload_3
    //   147: areturn
    //   148: aload_1
    //   149: ifnull +9 -> 158
    //   152: aload_1
    //   153: invokeinterface 236 1 0
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull -6 -> 158
    //   167: aload_1
    //   168: invokeinterface 236 1 0
    //   173: goto -15 -> 158
    //   176: astore_1
    //   177: aload_2
    //   178: ifnull +9 -> 187
    //   181: aload_2
    //   182: invokeinterface 236 1 0
    //   187: aload_1
    //   188: athrow
    //   189: astore_3
    //   190: aload_1
    //   191: astore_2
    //   192: aload_3
    //   193: astore_1
    //   194: goto -17 -> 177
    //   197: astore_2
    //   198: goto -35 -> 163
    //   201: aconst_null
    //   202: astore_2
    //   203: goto -78 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	ShortcutGuideActivity
    //   11	142	1	localObject1	Object
    //   160	1	1	localException1	java.lang.Exception
    //   162	6	1	localObject2	Object
    //   176	15	1	localObject3	Object
    //   193	1	1	localObject4	Object
    //   1	191	2	localObject5	Object
    //   197	1	2	localException2	java.lang.Exception
    //   202	1	2	localObject6	Object
    //   67	80	3	localObject7	Object
    //   189	4	3	localObject8	Object
    //   72	3	4	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   74	104	160	java/lang/Exception
    //   74	104	176	finally
    //   108	125	189	finally
    //   129	134	189	finally
    //   108	125	197	java/lang/Exception
    //   129	134	197	java/lang/Exception
  }
  
  private Bitmap d()
  {
    return ImageUtil.a(BitmapManager.a(getResources(), 2130839075), 14.0F, 540, 620);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (BaseActivity.a(getIntent()))
    {
      finish();
      return true;
    }
    if (!this.jdField_a_of_type_Boolean) {
      showPreview();
    }
    if (!this.b)
    {
      paramBundle = a();
      if (paramBundle == null) {
        break label104;
      }
      ((ImageView)findViewById(2131233160)).setImageBitmap(paramBundle);
    }
    for (;;)
    {
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_head", 0, 0, "", "", "", "");
      return true;
      label104:
      ((ImageView)findViewById(2131233160)).setImageResource(2130838018);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    if (BaseActivity.a(paramIntent))
    {
      finish();
      return;
    }
    setIntent(paramIntent);
    a();
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = getIntent();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      localIntent.setClassName(this, ShortcutRouterActivity.class.getName());
      startActivity(localIntent);
      finish();
      return;
      localIntent.putExtra("shotcut_forward", ChatActivity.class.getName());
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Fast_launch", "Fast_launch_msg", 0, 0, "0", "", "", "");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (a(this, paramMotionEvent)))
    {
      finish();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean showPreview()
  {
    setContentView(2130903629);
    a();
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutGuideActivity
 * JD-Core Version:    0.7.0.1
 */