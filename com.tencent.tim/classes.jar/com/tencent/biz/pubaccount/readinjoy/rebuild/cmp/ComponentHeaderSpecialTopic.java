package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import kbp;
import kwz;
import kxm;
import lie;
import mas;
import odv;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ComponentHeaderSpecialTopic
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private KandianUrlImageView J;
  private TextView qC;
  
  public ComponentHeaderSpecialTopic(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderSpecialTopic(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderSpecialTopic(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private URL a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo.mHeaderIconUrl == null) {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
        if (TextUtils.isEmpty(str)) {
          QLog.w("ComponentHeaderSpecialTopic", 1, "ReadInJoyHeader special topic icon url empty");
        }
        if (TextUtils.isEmpty(str)) {
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject = null;
        }
        Object localObject = kxm.b((String)localObject);
        paramArticleInfo.mHeaderIconUrl = ((URL)localObject);
        return localObject;
      }
    }
    return paramArticleInfo.mHeaderIconUrl;
  }
  
  private void aOj()
  {
    String str = h(this.a.a.a());
    if (!TextUtils.isEmpty(str)) {
      kxm.aJ(getContext(), str);
    }
  }
  
  private String g(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ComponentHeaderSpecialTopic", 1, "ReadInJoyHeader special topic title empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private String h(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ComponentHeaderSpecialTopic", 1, "ReadInJoyHeader special topic url empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private void lO(String paramString)
  {
    try
    {
      JSONObject localJSONObject = kxm.v();
      localJSONObject.put("feeds_source", paramString);
      localJSONObject.put("kandian_mode", kxm.nR());
      String str = kxm.g(this.a.a.a());
      if (odv.aT(this.a.a.nh())) {}
      for (paramString = "0X8009357";; paramString = "0X800744D")
      {
        kbp.a(null, "CliOper", "", "", paramString, paramString, 0, 0, str, "", "", localJSONObject.toString(), false);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie)) {
      d((lie)paramObject);
    }
  }
  
  public void aHq()
  {
    super.aHq();
    setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.qC.setOnClickListener(this);
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.J = ((KandianUrlImageView)findViewById(2131376698));
    this.qC = ((TextView)findViewById(2131376689));
  }
  
  public void d(lie paramlie)
  {
    if ((paramlie.isShowHeader()) && (paramlie.oF() == 1)) {}
    ArticleInfo localArticleInfo;
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramlie.isShowHeader()) && (paramlie.oF() == 1)) {
        localArticleInfo = paramlie.a();
      }
      switch (paramlie.oF())
      {
      default: 
        return;
      }
    }
    paramlie = a(localArticleInfo);
    if (paramlie == null) {
      this.J.setVisibility(8);
    }
    for (;;)
    {
      this.qC.setText(g(localArticleInfo));
      return;
      this.J.setVisibility(0);
      kwz.a(this.J, paramlie, getContext());
    }
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560320, this, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (paramView == this) {
        aOj();
      }
      break;
    }
    for (;;)
    {
      lO(kxm.f(this.a.a.a()));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aOj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSpecialTopic
 * JD-Core Version:    0.7.0.1
 */