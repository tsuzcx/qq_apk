package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import aofk;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kvl;
import kxm;
import lie;
import mas;
import mbz;
import ndi;
import wja;

public class ComponentHeaderNewSocial
  extends ComponentHeaderFriendRecommend
{
  ReadInJoyYAFolderTextView d;
  ImageView jq;
  View kI;
  View kJ;
  TextView qz;
  
  public ComponentHeaderNewSocial(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderNewSocial(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderNewSocial(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private List<Long> d(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {}
    do
    {
      return null;
      localObject = paramArticleInfo.mSocialFeedInfo.iS;
    } while ((localObject == null) || (((List)localObject).size() == 0));
    paramArticleInfo = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArticleInfo.add(Long.valueOf(((SocializeFeedsInfo.e)((Iterator)localObject).next()).uin));
    }
    return paramArticleInfo;
  }
  
  private void e(lie paramlie)
  {
    paramlie = paramlie.a();
    if (paramlie == null)
    {
      this.kI.setVisibility(8);
      this.kI.setOnClickListener(null);
      return;
    }
    List localList = d(paramlie);
    if ((localList == null) || (localList.size() == 0))
    {
      this.kI.setVisibility(8);
      this.kI.setOnClickListener(null);
      return;
    }
    this.kI.setVisibility(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("你的其他").append(localList.size()).append("个好友也Biu了");
    this.qz.setText(localStringBuilder.toString());
    this.kI.setOnClickListener(new mbz(this, paramlie));
  }
  
  private void f(lie paramlie)
  {
    ArticleInfo localArticleInfo = paramlie.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null))
    {
      this.kJ.setVisibility(8);
      return;
    }
    paramlie = localArticleInfo.mSocialFeedInfo;
    if ((paramlie.a != null) && (paramlie.a.iT != null) && (paramlie.a.iT.size() > 0) && ((paramlie.a.iT.size() != 1) || ((!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramlie.a.iT.get(0)).ahj)) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramlie.a.iT.get(0)).ahj, ":")) && (!TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramlie.a.iT.get(0)).ahj, "：")))))
    {
      this.kJ.setVisibility(0);
      List localList = paramlie.a.iT;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = new ArrayList();
      int i = localList.size();
      Object localObject1 = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).ahj;
      int j;
      label277:
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
      long l;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith(":")) || (((String)localObject1).startsWith("："))))
      {
        paramlie = ((String)localObject1).substring(1);
        localStringBuilder.append(paramlie);
        j = localStringBuilder.length();
        i -= 2;
        if (i < 0) {
          break label485;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.i.longValue();
        paramlie = ReadInJoyUserInfoModule.a(l, null);
        if (paramlie == null) {
          break label468;
        }
        paramlie = paramlie.nick;
        label320:
        localObject1 = "@" + paramlie;
        paramlie = (lie)localObject1;
        if (localBiuCommentInfo.aSO == 1) {
          paramlie = (String)localObject1 + " ";
        }
        if (localBiuCommentInfo.ahj != null) {
          break label475;
        }
      }
      label468:
      label475:
      for (localObject1 = "";; localObject1 = localBiuCommentInfo.ahj)
      {
        localStringBuilder.append(paramlie).append((String)localObject1);
        localObject1 = new c();
        ((c)localObject1).ahi = j;
        ((c)localObject1).adh = (paramlie.length() + j);
        ((c)localObject1).uin = l;
        ((List)localObject2).add(localObject1);
        j = localStringBuilder.length();
        i -= 1;
        break label277;
        paramlie = (lie)localObject1;
        if (localObject1 != null) {
          break;
        }
        paramlie = "";
        break;
        paramlie = ReadInJoyUserInfoModule.getDefaultNickName();
        break label320;
      }
      label485:
      paramlie = new SpannableStringBuilder(new aofk(localStringBuilder, 7, 16));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        paramlie.setSpan(new b(((c)localObject2).uin, -3355444), ((c)localObject2).ahi, ((c)localObject2).adh, 17);
      }
      this.d.setMaxLines(7);
      this.d.setMoreSpan(new a(localArticleInfo, -3355444));
      this.d.setText(paramlie);
      return;
    }
    if (!TextUtils.isEmpty(paramlie.ahL))
    {
      this.kJ.setVisibility(0);
      if (paramlie.ahL.length() >= 100) {
        paramlie.ahL = (paramlie.ahL.substring(0, 99) + '…');
      }
      this.d.setText(paramlie.ahL);
      return;
    }
    this.kJ.setVisibility(8);
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if (isShow()) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if ((paramObject instanceof lie))
      {
        paramObject = (lie)paramObject;
        e(paramObject);
        f(paramObject);
      }
      return;
    }
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.kI = findViewById(2131372318);
    kvl.setBackground(this.kI, getResources().getDrawable(2130842544));
    this.qz = ((TextView)findViewById(2131372320));
    this.jq = ((ImageView)findViewById(2131372319));
    this.kJ = findViewById(2131372315);
    this.d = ((ReadInJoyYAFolderTextView)findViewById(2131372316));
    this.d.setSpannableFactory(aofk.a);
    this.a[1].setVisibility(8);
    this.a[2].setVisibility(8);
    this.a[3].setVisibility(8);
    this.i.setTextSize(2, 15.5F);
    this.qx.setTextSize(2, 16.0F);
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560316, this, true);
  }
  
  public boolean isShow()
  {
    return true;
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    this.d.setTextColor(getContext().getResources().getColor(2131165381));
  }
  
  public class a
    extends ClickableSpan
    implements ReadInJoyYAFolderTextView.b
  {
    ArticleInfo articleInfo;
    private int bgColor = -1;
    boolean mIsPressed;
    private TextPaint mPaint;
    
    public a(ArticleInfo paramArticleInfo, int paramInt)
    {
      this.articleInfo = paramArticleInfo;
      this.bgColor = paramInt;
    }
    
    public void onClick(View paramView)
    {
      if (ndi.S(this.articleInfo))
      {
        kxm.a(ComponentHeaderNewSocial.this.getContext(), this.articleInfo, 0, false, 5, false);
        ndi.g(this.articleInfo, ComponentHeaderNewSocial.this.a.a.nh());
        return;
      }
      kxm.a(ComponentHeaderNewSocial.this.getContext(), this.articleInfo, false);
    }
    
    public void setPressed(boolean paramBoolean)
    {
      this.mIsPressed = paramBoolean;
      if (this.mPaint != null) {
        updateDrawState(this.mPaint);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      this.mPaint = paramTextPaint;
      this.mPaint.setColor(Color.parseColor("#285c95"));
      paramTextPaint = this.mPaint;
      if (this.mIsPressed) {}
      for (int i = this.bgColor;; i = -1)
      {
        paramTextPaint.bgColor = i;
        this.mPaint.setTextSize(wja.a(2, 14, ComponentHeaderNewSocial.this.getResources()));
        this.mPaint.setUnderlineText(false);
        return;
      }
    }
  }
  
  public class b
    extends ClickableSpan
    implements ReadInJoyYAFolderTextView.b
  {
    private int bgColor = -1;
    boolean mIsPressed;
    private TextPaint mPaint;
    protected long mUin;
    
    public b(long paramLong, int paramInt)
    {
      this.mUin = paramLong;
      this.bgColor = paramInt;
    }
    
    public void onClick(View paramView)
    {
      ComponentHeaderNewSocial.this.eD(this.mUin);
    }
    
    public void setPressed(boolean paramBoolean)
    {
      this.mIsPressed = paramBoolean;
      if (this.mPaint != null) {
        updateDrawState(this.mPaint);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      this.mPaint = paramTextPaint;
      this.mPaint.setColor(Color.parseColor("#285c95"));
      paramTextPaint = this.mPaint;
      if (this.mIsPressed) {}
      for (int i = this.bgColor;; i = -1)
      {
        paramTextPaint.bgColor = i;
        this.mPaint.setUnderlineText(false);
        return;
      }
    }
  }
  
  public static class c
  {
    public int adh;
    public int ahi;
    public long uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial
 * JD-Core Version:    0.7.0.1
 */