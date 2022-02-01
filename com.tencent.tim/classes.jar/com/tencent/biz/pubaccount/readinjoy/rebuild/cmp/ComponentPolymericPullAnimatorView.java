package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kbp;
import kxm;
import kys;
import lie;
import mcv;
import mhr;
import mhr.a;
import mhr.b;
import mhr.c;
import org.json.JSONObject;
import riw;

public class ComponentPolymericPullAnimatorView
  extends LinearLayout
{
  KandianUrlImageView K;
  int aQv;
  ComponentPolymericView b;
  lie d;
  View kS;
  View mContainer;
  public Context mContext;
  TextView mMoreText;
  TextView mTitle;
  
  public ComponentPolymericPullAnimatorView(Context paramContext, lie paramlie)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.d = paramlie;
    init();
  }
  
  private void init()
  {
    setOrientation(1);
    Object localObject1 = this.d.a();
    Object localObject2;
    if ((kxm.x((BaseArticleInfo)localObject1)) || (kxm.y((BaseArticleInfo)localObject1)))
    {
      localObject2 = LayoutInflater.from(this.mContext).inflate(2131560298, null);
      addView((View)localObject2);
      this.K = ((KandianUrlImageView)((View)localObject2).findViewById(2131368698));
      this.mTitle = ((TextView)((View)localObject2).findViewById(2131379769));
      this.mMoreText = ((TextView)((View)localObject2).findViewById(2131371927));
      this.kS = ((View)localObject2).findViewById(2131365990);
      this.mContainer = ((View)localObject2).findViewById(2131365322);
      if (!kys.dv(this.d.nh())) {
        break label361;
      }
      localObject1 = new LinearLayout.LayoutParams(-1, riw.dip2px(getContext(), 45.0F));
      this.mContainer.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.kS.setVisibility(8);
      this.aQv = 2130843659;
      this.K.setImageDrawable(getResources().getDrawable(this.aQv));
      localObject1 = new RelativeLayout.LayoutParams(riw.dip2px(getContext(), 18.0F), riw.dip2px(getContext(), 18.0F));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(riw.dip2px(getContext(), 12.0F), 0, riw.dip2px(getContext(), 6.0F), 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      this.K.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.mTitle.setTextColor(Color.parseColor("#262626"));
      this.mTitle.setTypeface(Typeface.defaultFromStyle(1));
      this.mTitle.setTextSize(0, Utils.rp2px(18.0D));
    }
    for (;;)
    {
      localObject1 = new RelativeLayout(this.mContext);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.b = new ComponentPolymericView(this.mContext);
      BezierSideBarView localBezierSideBarView = new BezierSideBarView(this.mContext);
      ((RelativeLayout)localObject1).addView(this.b, (ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).addView(localBezierSideBarView, (ViewGroup.LayoutParams)localObject2);
      this.b.setSideBarView(localBezierSideBarView);
      addView((View)localObject1);
      return;
      label361:
      localObject2 = new LinearLayout.LayoutParams(-1, riw.dip2px(getContext(), 36.0F));
      this.mContainer.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.kS.setVisibility(0);
      if (((ArticleInfo)localObject1).mNewPolymericInfo.aRX == 12)
      {
        this.aQv = 2130843847;
        this.K.setImageDrawable(getResources().getDrawable(this.aQv));
      }
      else if (((ArticleInfo)localObject1).mNewPolymericInfo.aRX == 13)
      {
        this.aQv = 2130843790;
        this.K.setImageDrawable(getResources().getDrawable(this.aQv));
      }
    }
  }
  
  public ComponentPolymericView a()
  {
    return this.b;
  }
  
  public void aOB()
  {
    ArticleInfo localArticleInfo = this.d.a();
    JSONObject localJSONObject;
    if ((kxm.x(localArticleInfo)) || (kxm.y(localArticleInfo))) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      Object localObject2;
      mhr.a locala;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject2 = new StringBuilder();
        Iterator localIterator = localArticleInfo.mNewPolymericInfo.iP.iterator();
        if (!localIterator.hasNext()) {
          break label369;
        }
        locala = (mhr.a)localIterator.next();
        if (!kxm.x(localArticleInfo)) {
          break label346;
        }
        localStringBuilder.append(locala.jdField_a_of_type_Mhr$c.aSe).append(",");
        continue;
        localObject2 = localArticleInfo.mFeedId + "";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label119:
      Object localObject1;
      if (kxm.x(localArticleInfo))
      {
        localObject1 = "1";
        kbp.a(null, "CliOper", "", "", "0X8009828", "0X8009828", 0, 0, (String)localObject2, (String)localObject1, localArticleInfo.mStrategyId + "", localJSONObject.toString(), false);
        if (TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.topIconUrl)) {}
      }
      try
      {
        localObject1 = new URL(localArticleInfo.mNewPolymericInfo.topIconUrl);
        this.K.setImagePlaceHolder(this.mContext.getResources().getDrawable(this.aQv)).setImage((URL)localObject1);
        if (!TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.ahm)) {
          this.mTitle.setText(localArticleInfo.mNewPolymericInfo.ahm);
        }
        if (!TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.ahn)) {
          this.mMoreText.setText(localArticleInfo.mNewPolymericInfo.ahn);
        }
        if (!TextUtils.isEmpty(localArticleInfo.mNewPolymericInfo.aho)) {
          this.mMoreText.setOnClickListener(new mcv(this, localArticleInfo, localJSONObject));
        }
        return;
        label346:
        ((StringBuilder)localObject2).append(locala.jdField_a_of_type_Mhr$b.rowKey).append(",");
        continue;
        label369:
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
        localJSONObject.put("channel_id", this.d.nh());
        localJSONObject.put("rowkey", ((StringBuilder)localObject2).toString());
        localJSONObject.put("topicid", ((StringBuilder)localObject1).toString());
        break label119;
        localObject1 = "2";
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.d("ComponentPolymericPullAnimatorView topic icon", 2, localMalformedURLException, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericPullAnimatorView
 * JD-Core Version:    0.7.0.1
 */