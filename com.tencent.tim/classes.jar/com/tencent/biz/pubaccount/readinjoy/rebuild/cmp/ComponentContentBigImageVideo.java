package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aqiw;
import aqux;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import kwz;
import kxm;
import lie;
import mhr;
import ndi;
import wja;

public class ComponentContentBigImageVideo
  extends ComponentContentBig
{
  private ImageView fc;
  private TextView qi;
  private TextView qj;
  
  public ComponentContentBigImageVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
    if ((paramObject instanceof lie))
    {
      paramObject = ((lie)paramObject).a();
      if (paramObject != null)
      {
        if (((ndi.ak(paramObject)) || (ndi.S(paramObject)) || (ndi.T(paramObject)) || (ndi.U(paramObject))) && ((ndi.aa(paramObject)) && (!ndi.K(paramObject)) && (!ndi.N(paramObject)))) {
          break label102;
        }
        if (!aqiw.isWifiConnected(getContext())) {
          break label147;
        }
        this.fc.setVisibility(0);
        this.qj.setVisibility(4);
      }
    }
    label102:
    do
    {
      return;
      if (kxm.B(paramObject))
      {
        this.qi.setVisibility(8);
        this.a.setVisibility(8);
        break;
      }
      this.qi.setText(kwz.ba(paramObject.mVideoDuration));
      break;
      this.fc.setVisibility(4);
      this.qj.setVisibility(0);
      Drawable localDrawable = getContext().getResources().getDrawable(2130843983);
      this.qj.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.qj.setCompoundDrawablePadding(wja.dp2px(6.0F, getContext().getResources()));
      this.qj.setVisibility(0);
    } while ((aqux.Mv() == 1) || (paramObject.mXGFileSize <= 0L));
    label147:
  }
  
  public URL a(lie paramlie)
  {
    Object localObject1 = paramlie.a();
    Object localObject2;
    if (paramlie.getCellType() == 51)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentBigImageVideo", 2, "PolymericArticle use first page url");
      }
      if ((kxm.B((BaseArticleInfo)localObject1)) && (((ArticleInfo)localObject1).mSinglePicture != null) && (((ArticleInfo)localObject1).mNewPolymericInfo != null) && (!((ArticleInfo)localObject1).mNewPolymericInfo.amy))
      {
        paramlie = ((ArticleInfo)localObject1).mSinglePicture.getFile();
        localObject2 = kwz.j();
        paramlie = kxm.c(paramlie, ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        ((ArticleInfo)localObject1).mSinglePicture = kxm.b(paramlie);
        ((ArticleInfo)localObject1).mNewPolymericInfo.amy = true;
        if (QLog.isColorLevel()) {
          QLog.e("ComponentContentBigImageVideo", 2, " handled url = " + paramlie);
        }
      }
      paramlie = ((ArticleInfo)localObject1).mSinglePicture;
      return paramlie;
    }
    if ((this.v != null) && (this.v.getLayoutParams() != null))
    {
      localObject2 = this.v.getLayoutParams();
      int i = ((ViewGroup.LayoutParams)localObject2).width;
      int j = ((ViewGroup.LayoutParams)localObject2).height;
      if (i == j) {
        localObject1 = ((ArticleInfo)localObject1).getVideoCoverWithSmartCut(i, j);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label307;
        }
        paramlie = (lie)localObject1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ComponentContentBigImageVideo", 2, "cut url : " + localObject1 + " width:" + i + "    height:" + j);
        return localObject1;
        if (i > j) {
          localObject1 = ((ArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(false);
        } else {
          localObject1 = ((ArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(true);
        }
      }
    }
    label307:
    return super.a(paramlie);
  }
  
  public void aNf()
  {
    super.aNf();
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
    this.qi = ((TextView)paramView.findViewById(2131366156));
    this.fc = ((ImageView)paramView.findViewById(2131373387));
    this.qj = ((TextView)paramView.findViewById(2131382385));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560296, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigImageVideo
 * JD-Core Version:    0.7.0.1
 */