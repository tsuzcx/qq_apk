package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.ui.DownloadAppActivity;
import com.tencent.token.ui.DownloadQQSecureActivity;
import com.tencent.token.ui.base.GuideQQPimSecureDialog;
import com.tencent.token.ui.base.GuideQQPimSecureTipsView;
import com.tencent.token.ui.gallery.GalleryActivity;
import com.tencent.token.ui.qqpim.QQPimNewActivity;
import com.tencent.token.utils.a;
import com.tmsdk.TMSDKContext;
import com.tmsdk.common.util.TmsLog;
import java.util.ArrayList;
import java.util.HashSet;

public class j
{
  private i a;
  private i b;
  private i c;
  private i d;
  private String e;
  private String f;
  private String g;
  
  private j()
  {
    a(false);
  }
  
  public static j a()
  {
    return a.a;
  }
  
  private void a(boolean paramBoolean)
  {
    this.a = i.a("key_dialog_cofig_6348", ef.c("key_dialog_cofig_6348", null));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dialog config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.a);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.b = i.a("key_tips1_cofig_6348", ef.c("key_tips1_cofig_6348", null));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tips1 config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.b);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.c = i.a("key_tips2_cofig_6348", ef.c("key_tips2_cofig_6348", null));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tips2 config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.c);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.d = i.a("key_eval_cofig_6348", ef.c("key_eval_cofig_6348", null));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("eval config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.d);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
  }
  
  static String b(String paramString)
  {
    if ("com.tencent.gallerymanager".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=14&c=102322&vt=1&pf=0";
    }
    if ("com.tencent.qqpimsecure".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=1&c=107013&vt=1&pf=0";
    }
    if ("com.tencent.qqpim".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=11&c=106613&vt=1&pf=0";
    }
    if ("android.lite.clean".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=25&c=107047&vt=1&pf=0";
    }
    if ("com.tencent.gamestick".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=18&c=102798&vt=1&pf=0";
    }
    if ("com.tencent.transfer".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=15&c=106613&vt=1&pf=0";
    }
    return "";
  }
  
  public i a(String paramString)
  {
    if ("key_dialog_cofig_6348".equals(paramString)) {
      return this.a;
    }
    if ("key_tips1_cofig_6348".equals(paramString)) {
      return this.b;
    }
    if ("key_tips2_cofig_6348".equals(paramString)) {
      return this.c;
    }
    if ("key_eval_cofig_6348".equals(paramString)) {
      return this.d;
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    TmsLog.i("GuideMgr", "invoke tryShowGuideDialog()");
    try
    {
      i locali = a("key_dialog_cofig_6348");
      if ((locali != null) && (locali.a()))
      {
        k localk = locali.a(paramContext, null);
        if (localk == null)
        {
          TmsLog.w("GuideMgr", "@tryShowGuideDialog() no pkg matched.");
          return;
        }
        if (TextUtils.isEmpty(localk.a)) {
          return;
        }
        if ((!TextUtils.isEmpty(localk.b)) && (!TextUtils.isEmpty(localk.c)) && (!TextUtils.isEmpty(localk.d)) && (!TextUtils.isEmpty(localk.f)))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localk.d);
          localArrayList.add(localk.e);
          localArrayList.add(localk.f);
          if (!TextUtils.isEmpty(localk.c)) {
            localk.h.add(localk.c);
          }
          paramContext = new GuideQQPimSecureDialog(paramContext, localk.a, localk.b, localArrayList, localk.h);
          try
          {
            paramContext.show();
            locali.a(localk.a);
            this.e = localk.a;
            TmsLog.w("GuideMgr", "@tryShowGuideDialog() show sucess.");
            b();
            TMSDKContext.SaveStringData(1150161, localk.a);
            return;
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
            return;
          }
        }
        TmsLog.w("GuideMgr", "@tryShowGuideDialog() ui data illegal.");
        return;
      }
      TmsLog.w("GuideMgr", "@tryShowGuideDialog() json data invalid, or time is not ok.");
      return;
    }
    catch (Exception paramContext)
    {
      TmsLog.e("GuideMgr", "", paramContext);
    }
  }
  
  public void a(Context paramContext, String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 4))
    {
      Intent localIntent = new Intent(paramContext, DownloadAppActivity.class);
      localIntent.putExtra("downloadurl", b(paramString));
      localIntent.putExtra("title", (String)paramArrayList.get(0));
      localIntent.putExtra("des", (String)paramArrayList.get(1));
      localIntent.putExtra("subdes", (String)paramArrayList.get(2));
      localIntent.putExtra("button", (String)paramArrayList.get(3));
      localIntent.putExtra("imgurl", (String)paramArrayList.get(4));
      localIntent.putExtra("pkg", paramString);
      paramContext.startActivity(localIntent);
      return;
    }
    if ("com.tencent.qqpimsecure".equals(paramString))
    {
      paramContext.startActivity(new Intent(paramContext, DownloadQQSecureActivity.class));
      return;
    }
    if ("com.tencent.qqpim".equals(paramString))
    {
      paramContext.startActivity(new Intent(paramContext, QQPimNewActivity.class));
      return;
    }
    if ("com.tencent.gallerymanager".equals(paramString))
    {
      paramContext.startActivity(new Intent(paramContext, GalleryActivity.class));
      return;
    }
  }
  
  public void a(final View paramView, ImageView paramImageView, TextView paramTextView1, TextView paramTextView2)
  {
    TmsLog.i("GuideMgr", "invoke tryShowEvalGuide()");
    try
    {
      i locali = a("key_eval_cofig_6348");
      if ((locali != null) && (locali.a()))
      {
        Object localObject = new HashSet();
        if (!TextUtils.isEmpty(this.e)) {
          ((HashSet)localObject).add(this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
          ((HashSet)localObject).add(this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
          ((HashSet)localObject).add(this.g);
        }
        localObject = locali.a(paramView.getContext(), (HashSet)localObject);
        if (localObject == null)
        {
          TmsLog.w("GuideMgr", "@tryShowEvalGuide() no pkg matched.");
          return;
        }
        if (TextUtils.isEmpty(((k)localObject).a)) {
          return;
        }
        if ((!TextUtils.isEmpty(((k)localObject).d)) && (!TextUtils.isEmpty(((k)localObject).e)) && (!TextUtils.isEmpty(((k)localObject).b)))
        {
          if ("com.tencent.qqpim".equals(((k)localObject).a)) {
            TMSDKContext.saveActionData(170019);
          }
          if (!TextUtils.isEmpty(((k)localObject).c)) {
            ((k)localObject).h.add(((k)localObject).c);
          }
          paramView.setVisibility(0);
          paramView.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              if ("com.tencent.qqpim".equals(this.a.a)) {
                TMSDKContext.saveActionData(170020);
              }
              j.this.a(paramView.getContext(), this.a.a, this.a.h);
              TMSDKContext.SaveStringData(1150168, this.a.a);
            }
          });
          paramTextView1.setText(((k)localObject).d);
          paramTextView2.setText(((k)localObject).e);
          new a(paramImageView).execute(new String[] { ((k)localObject).b });
          locali.a(((k)localObject).a);
          TmsLog.w("GuideMgr", "@tryShowEvalGuide() show sucess.");
          TMSDKContext.SaveStringData(1150167, ((k)localObject).a);
          b();
          return;
        }
        TmsLog.w("GuideMgr", "@tryShowEvalGuide() ui data illegal.");
        return;
      }
      TmsLog.w("GuideMgr", "@tryShowEvalGuide() json data invalid, or time is not ok.");
      return;
    }
    catch (Exception paramView)
    {
      TmsLog.e("GuideMgr", "", paramView);
    }
  }
  
  public void a(GuideQQPimSecureTipsView paramGuideQQPimSecureTipsView)
  {
    TmsLog.i("GuideMgr", "invoke tryShowTips1()");
    try
    {
      i locali = a("key_tips1_cofig_6348");
      if ((locali != null) && (locali.a()))
      {
        k localk = locali.a(paramGuideQQPimSecureTipsView.getContext(), null);
        if (localk == null)
        {
          TmsLog.w("GuideMgr", "@tryShowTips1() no pkg matched.");
          return;
        }
        if (TextUtils.isEmpty(localk.a)) {
          return;
        }
        if ((!TextUtils.isEmpty(localk.d)) && (!TextUtils.isEmpty(localk.e)))
        {
          if (!TextUtils.isEmpty(localk.c)) {
            localk.h.add(localk.c);
          }
          paramGuideQQPimSecureTipsView.a(localk.a, localk.d, localk.e, localk.b, localk.h, false);
          paramGuideQQPimSecureTipsView.setVisibility(0);
          locali.a(localk.a);
          this.f = localk.a;
          TmsLog.w("GuideMgr", "@tryShowTips1() show sucess.");
          b();
          TMSDKContext.SaveStringData(1150163, localk.a);
          return;
        }
        TmsLog.w("GuideMgr", "@tryShowGuideDialog() ui data illegal.");
        return;
      }
      TmsLog.w("GuideMgr", "@tryShowTips1() json data invalid, or time is not ok.");
      return;
    }
    catch (Exception paramGuideQQPimSecureTipsView)
    {
      TmsLog.e("GuideMgr", "", paramGuideQQPimSecureTipsView);
    }
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(GuideQQPimSecureTipsView paramGuideQQPimSecureTipsView)
  {
    TmsLog.i("GuideMgr", "invoke tryShowTips2()");
    try
    {
      i locali = a("key_tips2_cofig_6348");
      if ((locali != null) && (locali.a()))
      {
        k localk = locali.a(paramGuideQQPimSecureTipsView.getContext(), null);
        if (localk == null)
        {
          TmsLog.w("GuideMgr", "@tryShowTips2() no pkg matched.");
          return;
        }
        if (TextUtils.isEmpty(localk.a)) {
          return;
        }
        if ((!TextUtils.isEmpty(localk.d)) && (!TextUtils.isEmpty(localk.e)))
        {
          if (!TextUtils.isEmpty(localk.c)) {
            localk.h.add(localk.c);
          }
          paramGuideQQPimSecureTipsView.a(localk.a, localk.d, localk.e, localk.b, localk.h, true);
          paramGuideQQPimSecureTipsView.setVisibility(0);
          locali.a(localk.a);
          this.g = localk.a;
          TmsLog.w("GuideMgr", "@tryShowTips2() show sucess.");
          b();
          TMSDKContext.SaveStringData(1150165, localk.a);
          return;
        }
        TmsLog.w("GuideMgr", "@tryShowTips2() ui data illegal.");
        return;
      }
      TmsLog.w("GuideMgr", "@tryShowTips2() json data invalid, or time is not ok.");
      return;
    }
    catch (Exception paramGuideQQPimSecureTipsView)
    {
      TmsLog.e("GuideMgr", "", paramGuideQQPimSecureTipsView);
    }
  }
  
  private static class a
  {
    static j a = new j(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.j
 * JD-Core Version:    0.7.0.1
 */