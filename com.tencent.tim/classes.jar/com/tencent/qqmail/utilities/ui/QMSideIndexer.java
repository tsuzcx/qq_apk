package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.qmui.helper.QMUIDisplayHelper;
import com.tencent.qqmail.utilities.StatusBarUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class QMSideIndexer
  extends LinearLayout
{
  public static final String Compact = "*";
  public static final String Frequency = "&";
  private static int MAX_ITEM_HEIGHT = QMUIKit.dpToPx(18);
  public static final String Other = "Ξ";
  public static final String Search = "{$}";
  private QMSideIndexerCallback callback;
  private List<String> compactedIdxList = new ArrayList();
  private List<String> indexList = new ArrayList();
  private int paddingTop = 0;
  private boolean reDraw = true;
  private int sideIndexerMaxHeight;
  
  public QMSideIndexer(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMSideIndexer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void clear()
  {
    removeAllViews();
    this.compactedIdxList.clear();
  }
  
  private int compactIndex()
  {
    int k = this.indexList.size();
    if (k == 0)
    {
      this.compactedIdxList.addAll(this.indexList);
      return 1;
    }
    int i = k - (int)Math.ceil(this.sideIndexerMaxHeight / MAX_ITEM_HEIGHT);
    int m;
    int j;
    if (i > 0)
    {
      m = (int)Math.ceil(k / i);
      j = 0;
      i = 1;
      if (i > k) {
        break label157;
      }
      if (i % m != 0) {
        break label101;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      this.compactedIdxList.addAll(this.indexList);
      return 1;
      label101:
      j += 1;
      if ((j > 2) && ((j & 0x1) == 1)) {
        this.compactedIdxList.add("*");
      } else {
        this.compactedIdxList.add(this.indexList.get(i - 1));
      }
    }
    label157:
    return m;
  }
  
  private void draw()
  {
    clear();
    compactIndex();
    int j = this.compactedIdxList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (String)this.compactedIdxList.get(i);
      Object localObject2;
      LinearLayout.LayoutParams localLayoutParams;
      if ("{$}".equals(localObject1))
      {
        localObject2 = new ImageView(getContext());
        ((ImageView)localObject2).setImageResource(2130841048);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
        localLayoutParams.setMargins(0, 0, 0, 0);
        ((ImageView)localObject2).setPadding(0, 3, 0, 0);
        ((ImageView)localObject2).setLayoutParams(localLayoutParams);
        ((ImageView)localObject2).setMaxHeight(MAX_ITEM_HEIGHT);
        addView((View)localObject2);
        ((ImageView)localObject2).setTag(localObject1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (StringUtils.equals("&", (CharSequence)localObject1))
        {
          localObject2 = new ImageView(getContext());
          ((ImageView)localObject2).setImageResource(2130841039);
          localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
          localLayoutParams.setMargins(0, 0, 0, 0);
          ((ImageView)localObject2).setPadding(0, 3, 0, 0);
          ((ImageView)localObject2).setLayoutParams(localLayoutParams);
          ((ImageView)localObject2).setMaxHeight(MAX_ITEM_HEIGHT);
          ((ImageView)localObject2).setTag(localObject1);
          addView((View)localObject2);
        }
        else
        {
          localObject2 = new TextView(getContext());
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject2).setTag(localObject1);
          ((TextView)localObject2).setTextSize(12.0F);
          ((TextView)localObject2).setTextColor(getResources().getColor(2131167531));
          localObject1 = new LinearLayout.LayoutParams(-2, -2, 1.0F);
          ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
          ((TextView)localObject2).setPadding(0, 0, 0, 0);
          ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((TextView)localObject2).setMaxHeight(MAX_ITEM_HEIGHT);
          ((TextView)localObject2).setGravity(17);
          addView((View)localObject2);
        }
      }
    }
    setOnTouchListener(new QMSideIndexer.1(this));
  }
  
  private boolean shouldRedraw(List<String> paramList)
  {
    if (paramList == this.indexList) {}
    for (;;)
    {
      return false;
      if (paramList.size() != this.indexList.size()) {
        return true;
      }
      int i = 0;
      while (i < this.indexList.size())
      {
        if (((String)this.indexList.get(i)).equals(paramList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void touchedIndex(int paramInt, String paramString)
  {
    this.callback.touchedSideIndexer(this, paramInt, paramString);
  }
  
  private void touchedSideIndexer(float paramFloat)
  {
    int j = 0;
    int k;
    Object localObject1;
    int i;
    Object localObject2;
    int n;
    if (this.callback != null)
    {
      int m = getChildCount();
      k = 0;
      localObject1 = null;
      i = 0;
      if (k < m)
      {
        localObject2 = getChildAt(k);
        n = ((View)localObject2).getHeight();
        localObject2 = (String)((View)localObject2).getTag();
        if (i + n + this.paddingTop < paramFloat) {
          break label283;
        }
        if ((!"*".equals(localObject1)) && (!"*".equals(localObject2))) {
          break label265;
        }
        paramFloat = (paramFloat - i) / n;
        if (localObject1 != null) {
          break label233;
        }
        label105:
        i = j;
        if (j < 0) {
          i = this.indexList.indexOf(localObject2);
        }
        if (k + 1 < m) {
          break label249;
        }
        localObject1 = null;
        label137:
        localObject1 = (String)localObject1;
        k = this.indexList.indexOf(localObject1);
        j = k;
        if (k < 0) {
          j = i;
        }
        float f = i;
        k = (int)((j - i) * paramFloat + f);
        j = i;
        if (k < this.indexList.size()) {
          if (k > 0) {
            break label301;
          }
        }
      }
    }
    label265:
    label283:
    label301:
    for (j = i;; j = k)
    {
      touchedIndex(j, (String)this.indexList.get(j));
      return;
      label233:
      j = this.indexList.indexOf(localObject1);
      break label105;
      label249:
      localObject1 = getChildAt(k + 1).getTag();
      break label137;
      touchedIndex(this.indexList.indexOf(localObject2), (String)localObject2);
      return;
      k += 1;
      i += n;
      localObject1 = localObject2;
      break;
    }
  }
  
  public void hide()
  {
    this.reDraw = true;
    setVisibility(8);
  }
  
  public void init()
  {
    setVisibility(8);
    this.sideIndexerMaxHeight = (QMUIDisplayHelper.getScreenHeight(getContext()) - getResources().getDimensionPixelSize(2131299361) - StatusBarUtil.getStatusBarHeight() - getResources().getDimensionPixelSize(2131299664));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt2);
    if (i != this.sideIndexerMaxHeight)
    {
      this.sideIndexerMaxHeight = i;
      if (!this.reDraw) {
        draw();
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void recycle()
  {
    this.callback = null;
    this.indexList = null;
    this.compactedIdxList = null;
  }
  
  public void setCallback(QMSideIndexerCallback paramQMSideIndexerCallback)
  {
    this.callback = paramQMSideIndexerCallback;
  }
  
  public void setIndexList(List<String> paramList)
  {
    this.reDraw = shouldRedraw(paramList);
    this.indexList = paramList;
  }
  
  public void show()
  {
    if (this.reDraw)
    {
      draw();
      this.reDraw = false;
    }
    if (this.indexList.size() < 5)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
  }
  
  public static abstract interface QMSideIndexerCallback
  {
    public abstract void touchedSideIndexer(QMSideIndexer paramQMSideIndexer, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMSideIndexer
 * JD-Core Version:    0.7.0.1
 */