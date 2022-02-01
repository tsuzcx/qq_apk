package com.tencent.qqmail.card.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.collect.HashMultimap;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.card.cursor.QMCardListCursor;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.view.card.BaseCard;
import com.tencent.qqmail.card.view.card.GeneralCard;
import com.tencent.qqmail.card.view.card.MineCard;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.Iterator;
import java.util.Set;

public class CardGalleryAdapter
  extends BaseAdapter
{
  private static final String TAG = "CardGalleryAdapter";
  private boolean isMine;
  private CardHandler mCardHandler;
  private int mCardWidth;
  private final Context mContext;
  private QMCardListCursor mCursor = null;
  private PreHeatViewPool mPreHeatViewPool;
  
  public CardGalleryAdapter(Context paramContext, CardHandler paramCardHandler)
  {
    this.mContext = paramContext;
    this.mCardHandler = paramCardHandler;
    this.mCardWidth = (QMUIKit.getScreenWidth() - this.mContext.getResources().getDimensionPixelSize(2131296825) * 2 - this.mContext.getResources().getDimensionPixelSize(2131296809) * 2);
    this.mPreHeatViewPool = new PreHeatViewPool(null);
    this.mPreHeatViewPool.preHeat(paramContext);
  }
  
  private BaseCard generateCardView(QMCardData paramQMCardData)
  {
    paramQMCardData = null;
    if (0 == 0) {
      if (!this.isMine) {
        break label35;
      }
    }
    label35:
    for (paramQMCardData = new MineCard(this.mContext);; paramQMCardData = new GeneralCard(this.mContext))
    {
      paramQMCardData.setCardWidth(this.mCardWidth);
      return paramQMCardData;
    }
  }
  
  public int getCount()
  {
    if (this.mCursor == null) {
      return 0;
    }
    return this.mCursor.getCount();
  }
  
  public QMCardData getItem(int paramInt)
  {
    return this.mCursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.isMine) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Log.v("CardGalleryAdapter", "getView: " + paramInt + ", isMine: " + this.isMine);
    QMCardData localQMCardData = getItem(paramInt);
    if (paramView == null) {
      paramView = generateCardView(localQMCardData);
    }
    for (;;)
    {
      BaseCard localBaseCard = (BaseCard)paramView;
      localBaseCard.render(localQMCardData, this.mCardHandler);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localBaseCard;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setCardHandler(CardHandler paramCardHandler)
  {
    this.mCardHandler = paramCardHandler;
  }
  
  public void setCursor(QMCardListCursor paramQMCardListCursor, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setCursor: ").append(paramBoolean).append(", cnt: ");
    if (paramQMCardListCursor == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramQMCardListCursor.getCount()))
    {
      Log.i("CardGalleryAdapter", localObject);
      this.isMine = paramBoolean;
      if (this.mCursor != paramQMCardListCursor) {
        this.mCursor = paramQMCardListCursor;
      }
      return;
    }
  }
  
  static class PreHeatViewPool
  {
    private static final int HEAT_SIZE = 4;
    private HashMultimap<Class<?>, BaseCard> mPool = HashMultimap.create();
    
    public BaseCard getPreHeatView(Class<?> paramClass)
    {
      paramClass = this.mPool.get(paramClass);
      if ((paramClass != null) && (!paramClass.isEmpty()))
      {
        BaseCard localBaseCard = (BaseCard)paramClass.iterator().next();
        if (localBaseCard != null)
        {
          paramClass.remove(localBaseCard);
          return localBaseCard;
        }
      }
      return null;
    }
    
    public void preHeat(Context paramContext)
    {
      this.mPool.put(MineCard.class, new MineCard(paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */