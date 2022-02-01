import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class ante
  extends anqv
{
  String btnText;
  boolean cJV;
  String contentType;
  String faceUrl;
  String puin;
  
  protected int IX()
  {
    return 20;
  }
  
  View a(View paramView, Context paramContext, String paramString)
  {
    ante.a locala2;
    try
    {
      i = Integer.parseInt(this.contentType);
      if (paramView == null)
      {
        ante.a locala1 = new ante.a();
        paramView = View.inflate(paramContext, 2131562093, null);
        locala1.F = ((SingleLineTextView)paramView.findViewById(2131372190));
        locala1.icon = ((ImageView)paramView.findViewById(2131368698));
        locala1.Zw = ((TextView)paramView.findViewById(2131367381));
        locala1.pw = paramView.findViewById(2131370787);
        paramView.setTag(locala1);
        locala1.F.setText(paramString);
        if (i != 1) {
          break label331;
        }
        locala1.icon.setVisibility(8);
        locala1.F.setTextColor(Color.parseColor("#777777"));
        locala1.F.setTextSize(14.0F);
        locala1.F.setCompoundDrawables(null, null);
        locala1.Zw.setText(this.btnText);
        locala1.Zw.setEnabled(true);
        locala1.Zw.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839561));
        paramView.setTag(2131375406, this.ku);
        locala1.Zw.setTag(2131375406, this.ku);
        i = wja.dp2px(17.0F, paramContext.getResources());
        int j = wja.dp2px(16.0F, paramContext.getResources());
        locala1.Zw.setPadding(j, 0, j, 0);
        locala1.Zw.post(new StructMsgItemLayout20.1(this, i, locala1));
        paramView.setOnClickListener(this);
        locala1.Zw.setOnClickListener(this);
        return paramView;
      }
    }
    catch (Exception localException)
    {
      label331:
      do
      {
        for (;;)
        {
          QLog.e("StructMsgItemLayout20", 1, "content type:" + this.contentType);
          i = 0;
          continue;
          locala2 = (ante.a)paramView.getTag();
        }
      } while (i != 0);
      locala2.icon.setVisibility(0);
      paramString = paramContext.getResources().getDrawable(2130840645);
      if (TextUtils.isEmpty(this.faceUrl)) {
        break label639;
      }
    }
    int i = wja.dp2px(40.0F, paramContext.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString;
    localURLDrawableOptions.mFailedDrawable = paramString;
    paramString = URLDrawable.getDrawable(this.faceUrl, localURLDrawableOptions);
    if (paramString.getStatus() == 2) {
      paramString.restartDownload();
    }
    paramString.setTag(aqbn.d(i, i, i / 2));
    paramString.setDecodeHandler(aqbn.d);
    locala2.icon.setImageDrawable(paramString);
    label446:
    if (this.cJV)
    {
      paramString = paramContext.getResources().getDrawable(2130842599);
      locala2.F.setCompoundDrawablePadding(wja.dp2px(3.0F, paramContext.getResources()));
      paramString.setBounds(0, 0, wja.dp2px(15.0F, paramContext.getResources()), wja.dp2px(15.0F, paramContext.getResources()));
      locala2.F.setCompoundDrawables(null, paramString);
      locala2.F.setTextColor(Color.parseColor("#000000"));
      locala2.F.setTextSize(17.0F);
      locala2.Zw.setTag(locala2);
      if (!((acja)((BaseActivity)paramContext).app.getManager(56)).f(Long.valueOf(Long.parseLong(this.puin)))) {
        break label664;
      }
      locala2.Zw.setBackgroundDrawable(null);
      locala2.Zw.setText(acfp.m(2131715012));
      locala2.Zw.setEnabled(false);
    }
    for (;;)
    {
      label514:
      paramView.setTag(2131375408, this.puin);
      locala2.Zw.setTag(2131375408, this.puin);
      break;
      label639:
      locala2.icon.setImageDrawable(paramString);
      break label446;
      locala2.F.setCompoundDrawables(null, null);
      break label514;
      label664:
      locala2.Zw.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839561));
      locala2.Zw.setText(acfp.m(2131715018));
      locala2.Zw.setEnabled(true);
    }
  }
  
  public boolean a(ansf paramansf)
  {
    super.a(paramansf);
    dTy();
    return true;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && (((LinearLayout)paramView).getChildCount() == this.rz.size()))
    {
      paramBundle = (LinearLayout)paramView;
      localObject = this.rz.iterator();
      int i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          anqu localanqu = (anqu)((Iterator)localObject).next();
          localanqu.hU = this.hU;
          if ("content".equals(localanqu.mTypeName))
          {
            localObject = ((ansq)localanqu).text;
            a(((LinearLayout)paramView).getChildAt(i), paramContext, (String)localObject);
          }
        }
        else
        {
          return paramBundle;
        }
        i += 1;
      }
    }
    paramView = new LinearLayout(paramContext);
    paramBundle = this.rz.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (anqu)paramBundle.next();
      ((anqu)localObject).hU = this.hU;
      if (("content".equals(((anqu)localObject).mTypeName)) && ((localObject instanceof ansq))) {
        paramView.addView(a(null, paramContext, ((ansq)localObject).text), new LinearLayout.LayoutParams(-1, -2));
      }
    }
    return paramView;
  }
  
  void dTy()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.chc);
      this.contentType = localJSONObject.optString("contentType");
      if (localJSONObject.optInt("isCert") == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.cJV = bool;
        this.faceUrl = localJSONObject.optString("faceUrl");
        this.btnText = localJSONObject.optString("btnText");
        this.puin = localJSONObject.optString("puin");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("StructMsgItemLayout20", 1, "Exception:" + localException);
    }
  }
  
  public String getName()
  {
    return "Layout20";
  }
  
  /* Error */
  public void onClick(View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	ante:contentType	Ljava/lang/String;
    //   4: invokestatic 35	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   7: istore_2
    //   8: aload_1
    //   9: invokevirtual 404	android/view/View:getContext	()Landroid/content/Context;
    //   12: astore 5
    //   14: aload 5
    //   16: instanceof 406
    //   19: ifne +11 -> 30
    //   22: invokestatic 412	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   25: aload_1
    //   26: invokevirtual 415	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   29: return
    //   30: aload 5
    //   32: checkcast 406	android/support/v4/app/FragmentActivity
    //   35: astore 4
    //   37: aload 5
    //   39: checkcast 406	android/support/v4/app/FragmentActivity
    //   42: invokevirtual 419	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +163 -> 210
    //   50: aload_3
    //   51: invokevirtual 425	com/tencent/mobileqq/activity/ChatFragment:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull -34 -> 22
    //   59: aload_3
    //   60: bipush 88
    //   62: invokevirtual 429	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   65: checkcast 431	kec
    //   68: astore 6
    //   70: iload_2
    //   71: iconst_1
    //   72: if_icmpne +160 -> 232
    //   75: aload_1
    //   76: ldc 131
    //   78: invokevirtual 434	android/view/View:getTag	(I)Ljava/lang/Object;
    //   81: checkcast 343	java/lang/String
    //   84: astore 4
    //   86: aload 4
    //   88: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne -69 -> 22
    //   94: new 436	android/content/Intent
    //   97: dup
    //   98: aload 5
    //   100: ldc_w 438
    //   103: invokespecial 441	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   106: astore 6
    //   108: aload 6
    //   110: ldc_w 443
    //   113: aload 4
    //   115: invokevirtual 447	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   118: pop
    //   119: aload 6
    //   121: ldc_w 449
    //   124: invokestatic 455	java/lang/System:currentTimeMillis	()J
    //   127: invokevirtual 458	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   130: pop
    //   131: aload 6
    //   133: ldc_w 460
    //   136: ldc_w 462
    //   139: invokevirtual 447	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   142: pop
    //   143: aload 5
    //   145: aload 6
    //   147: invokevirtual 466	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   150: aload_0
    //   151: getfield 469	ante:e	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   154: ifnull -132 -> 22
    //   157: new 471	kds$a
    //   160: dup
    //   161: invokespecial 472	kds$a:<init>	()V
    //   164: astore 4
    //   166: aload 4
    //   168: bipush 6
    //   170: putfield 476	kds$a:aId	I
    //   173: aload 4
    //   175: aload_0
    //   176: getfield 469	ante:e	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   179: getfield 482	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   182: invokestatic 487	kds:a	(Lkds$a;Lcom/tencent/mobileqq/data/MessageRecord;)Lkds$a;
    //   185: astore 4
    //   187: aload_3
    //   188: sipush 139
    //   191: invokevirtual 429	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   194: checkcast 484	kds
    //   197: aload 4
    //   199: aconst_null
    //   200: invokevirtual 490	kds:a	(Lkds$a;Ljava/lang/String;)V
    //   203: goto -181 -> 22
    //   206: astore_3
    //   207: goto -185 -> 22
    //   210: invokestatic 496	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   213: invokevirtual 500	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   216: astore_3
    //   217: aload_3
    //   218: instanceof 264
    //   221: ifeq +235 -> 456
    //   224: aload_3
    //   225: checkcast 264	com/tencent/mobileqq/app/QQAppInterface
    //   228: astore_3
    //   229: goto -174 -> 55
    //   232: iload_2
    //   233: ifne -211 -> 22
    //   236: aload_1
    //   237: ldc_w 294
    //   240: invokevirtual 434	android/view/View:getTag	(I)Ljava/lang/Object;
    //   243: checkcast 343	java/lang/String
    //   246: astore 5
    //   248: aload_1
    //   249: invokevirtual 503	android/view/View:getId	()I
    //   252: ldc_w 504
    //   255: if_icmpne +78 -> 333
    //   258: new 436	android/content/Intent
    //   261: dup
    //   262: invokespecial 505	android/content/Intent:<init>	()V
    //   265: astore 7
    //   267: aload 7
    //   269: ldc_w 507
    //   272: bipush 115
    //   274: invokevirtual 510	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   277: pop
    //   278: aload 7
    //   280: aload_3
    //   281: aload 4
    //   283: aload 5
    //   285: bipush 251
    //   287: invokestatic 515	ocp:a	(Landroid/content/Intent;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;I)V
    //   290: aload 6
    //   292: ldc_w 516
    //   295: aload_0
    //   296: getfield 469	ante:e	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   299: getfield 519	com/tencent/mobileqq/structmsg/AbsStructMsg:uin	Ljava/lang/String;
    //   302: aload_0
    //   303: getfield 469	ante:e	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   306: getfield 482	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   309: ldc_w 521
    //   312: invokevirtual 526	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   315: aconst_null
    //   316: aconst_null
    //   317: aload 5
    //   319: invokestatic 278	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   322: iconst_0
    //   323: invokevirtual 529	kec:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   326: goto -304 -> 22
    //   329: astore_3
    //   330: goto -308 -> 22
    //   333: aload_1
    //   334: invokevirtual 503	android/view/View:getId	()I
    //   337: ldc 64
    //   339: if_icmpne -317 -> 22
    //   342: aload_1
    //   343: invokevirtual 189	android/view/View:getTag	()Ljava/lang/Object;
    //   346: checkcast 6	ante$a
    //   349: astore 6
    //   351: aload 6
    //   353: getfield 70	ante$a:Zw	Landroid/widget/TextView;
    //   356: iconst_4
    //   357: invokevirtual 530	android/widget/TextView:setVisibility	(I)V
    //   360: aload 6
    //   362: getfield 75	ante$a:pw	Landroid/view/View;
    //   365: iconst_0
    //   366: invokevirtual 531	android/view/View:setVisibility	(I)V
    //   369: aload_3
    //   370: aload 4
    //   372: aload 5
    //   374: new 9	ante$b
    //   377: dup
    //   378: aload_0
    //   379: aload 6
    //   381: invokespecial 534	ante$b:<init>	(Lante;Lante$a;)V
    //   384: iconst_1
    //   385: iconst_3
    //   386: invokestatic 537	ocp:a	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Ljava/lang/String;Lacje;ZI)V
    //   389: new 471	kds$a
    //   392: dup
    //   393: invokespecial 472	kds$a:<init>	()V
    //   396: astore 4
    //   398: aload 4
    //   400: iconst_5
    //   401: putfield 476	kds$a:aId	I
    //   404: aload 4
    //   406: aload 5
    //   408: invokestatic 278	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   411: putfield 541	kds$a:rP	J
    //   414: aload 4
    //   416: aload_0
    //   417: getfield 469	ante:e	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   420: getfield 482	com/tencent/mobileqq/structmsg/AbsStructMsg:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   423: invokestatic 487	kds:a	(Lkds$a;Lcom/tencent/mobileqq/data/MessageRecord;)Lkds$a;
    //   426: astore 4
    //   428: aload_3
    //   429: sipush 139
    //   432: invokevirtual 429	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   435: checkcast 484	kds
    //   438: aload 4
    //   440: aconst_null
    //   441: invokevirtual 490	kds:a	(Lkds$a;Ljava/lang/String;)V
    //   444: goto -422 -> 22
    //   447: astore_3
    //   448: goto -426 -> 22
    //   451: astore 5
    //   453: goto -39 -> 414
    //   456: aconst_null
    //   457: astore_3
    //   458: goto -403 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	this	ante
    //   0	461	1	paramView	View
    //   7	226	2	i	int
    //   45	143	3	localObject1	Object
    //   206	1	3	localException1	Exception
    //   216	65	3	localObject2	Object
    //   329	100	3	localException2	Exception
    //   447	1	3	localException3	Exception
    //   457	1	3	localObject3	Object
    //   35	404	4	localObject4	Object
    //   12	395	5	localObject5	Object
    //   451	1	5	localException4	Exception
    //   68	312	6	localObject6	Object
    //   265	14	7	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   150	203	206	java/lang/Exception
    //   290	326	329	java/lang/Exception
    //   389	404	447	java/lang/Exception
    //   414	444	447	java/lang/Exception
    //   404	414	451	java/lang/Exception
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    dTy();
  }
  
  public class a
  {
    public SingleLineTextView F;
    public TextView Zw;
    public ImageView icon;
    public View pw;
    
    a() {}
  }
  
  class b
    extends acje
  {
    ante.a b = null;
    
    public b(ante.a parama)
    {
      this.b = parama;
    }
    
    public void m(boolean paramBoolean, String paramString)
    {
      if (this.b != null)
      {
        this.b.pw.setVisibility(8);
        this.b.Zw.setVisibility(0);
        if (paramBoolean)
        {
          this.b.Zw.setBackgroundDrawable(null);
          this.b.Zw.setText(acfp.m(2131715022));
          this.b.Zw.setEnabled(false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ante
 * JD-Core Version:    0.7.0.1
 */