package com.tencent.mobileqq.troop.homework.recite.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import jll;

public class ReciteDisplayView
  extends ListView
{
  protected ArticleInfo a;
  public WordInfo a;
  protected ReciteFragment a;
  protected long arD;
  protected boolean cQS;
  
  public ReciteDisplayView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReciteDisplayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReciteDisplayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public WordInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataWordInfo;
  }
  
  public int jH(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs == null)) {}
    while ((paramInt < 0) || (paramInt > this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size() - 1)) {
      return 0;
    }
    return ((ParagraphInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(paramInt)).generateOrGetWordInfoList(paramInt).size();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.cQS = true;
      continue;
      if (this.cQS)
      {
        this.arD = System.currentTimeMillis();
        this.cQS = false;
      }
    }
  }
  
  public void setArticleInfo(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = paramArticleInfo;
  }
  
  public void setFragment(ReciteFragment paramReciteFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment = paramReciteFragment;
  }
  
  public void t(int paramInt, float paramFloat)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.Lr() == 0)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ReciteDetect.ReciteDisplayView", 2, "背诵课文刷新, scrool2Y = " + paramFloat + ", mReciteDisplayView.getBottom() = " + getBottom() + ", mIsTouchMove = " + this.cQS);
        }
      } while ((this.cQS) || (System.currentTimeMillis() - this.arD <= 3000L));
      smoothScrollBy((int)paramFloat, 100);
    } while (!QLog.isColorLevel());
    QLog.i("ReciteDetect.ReciteDisplayView", 2, "背诵课文自动滚动到, scrool2Y：" + paramFloat);
  }
  
  public static class a
  {
    PinyinTextView b;
  }
  
  public static class b
    extends BaseAdapter
  {
    public static int dUw = 1;
    public static int dUx = 2;
    protected int AU;
    List<ParagraphInfo> HU;
    ReciteDisplayView a;
    int dUv = 1;
    int dUy = -2;
    int dUz = -1;
    Context mContext;
    int mode = dUw;
    
    public b(ReciteDisplayView paramReciteDisplayView, Context paramContext, List<ParagraphInfo> paramList, int paramInt1, int paramInt2)
    {
      this.a = paramReciteDisplayView;
      this.mContext = paramContext;
      this.AU = jll.getScreenHeight(paramContext);
      int i = paramList.size() - 1;
      while (i > 0)
      {
        paramReciteDisplayView = (ParagraphInfo)paramList.get(i);
        paramReciteDisplayView.paragraphPos = i;
        if ((TextUtils.isEmpty(paramReciteDisplayView.content_html)) && (TextUtils.isEmpty(paramReciteDisplayView.content_pinyin))) {
          paramList.remove(i);
        }
        i -= 1;
      }
      this.HU = paramList;
      this.dUv = paramInt1;
      this.mode = paramInt2;
    }
    
    public void a(WordInfo paramWordInfo)
    {
      if ((paramWordInfo == null) || (paramWordInfo.paragraphPos < 0) || (paramWordInfo.wordPos < 0) || (this.HU == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ReciteDetect.ReciteDisplayView", 1, "recite result = " + paramWordInfo.text);
      }
      if (paramWordInfo.paragraphPos > this.dUy) {
        this.dUy = paramWordInfo.paragraphPos;
      }
      for (this.dUz = paramWordInfo.wordPos;; this.dUz = paramWordInfo.wordPos) {
        do
        {
          this.a.a = paramWordInfo;
          notifyDataSetChanged();
          return;
        } while ((paramWordInfo.paragraphPos != this.dUy) || (paramWordInfo.wordPos <= this.dUz));
      }
    }
    
    public void dZR()
    {
      if (this.HU == null) {
        return;
      }
      int i = 0;
      while (i < this.HU.size())
      {
        ((ParagraphInfo)this.HU.get(i)).setWordColor(3);
        i += 1;
      }
      this.mode = dUw;
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      int j;
      if (this.mode == dUw)
      {
        j = this.HU.size();
        return j;
      }
      Iterator localIterator = this.HU.iterator();
      int i = 0;
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        j = i;
        if (((ParagraphInfo)localIterator.next()).paragraphPos > this.dUy) {
          break;
        }
        i += 1;
      }
    }
    
    public Object getItem(int paramInt)
    {
      return this.HU.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ReciteDisplayView.a locala;
      if (paramView == null)
      {
        locala = new ReciteDisplayView.a();
        locala.b = new PinyinTextView(this.a, this.mContext, this.dUv);
        paramView = locala.b;
        paramView.setTag(locala);
      }
      for (;;)
      {
        locala = (ReciteDisplayView.a)paramView.getTag();
        ParagraphInfo localParagraphInfo = (ParagraphInfo)this.HU.get(paramInt);
        if (this.mode == dUx) {
          if (paramInt == getCount() - 1) {
            locala.b.setWordInfos(localParagraphInfo, this.dUz, true);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          locala.b.setWordInfos(localParagraphInfo, this.dUz, false);
          continue;
          locala.b.setWordInfos(localParagraphInfo, this.dUz, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteDisplayView
 * JD-Core Version:    0.7.0.1
 */