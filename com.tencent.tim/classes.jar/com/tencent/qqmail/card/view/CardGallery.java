package com.tencent.qqmail.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.qqmail.card.cursor.QMCardListCursor;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.view.Gallery.EcoGallery;
import com.tencent.qqmail.utilities.thread.Threads;

public class CardGallery
  extends EcoGallery
{
  private static final String TAG = "CardGallery";
  private boolean clickTremble = false;
  private CardGalleryAdapter mAdapter;
  private CardHandler mCardHandler;
  
  public CardGallery(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public CardGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public CardGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    this.mAdapter = new CardGalleryAdapter(getContext(), this.mCardHandler);
    setAdapter(this.mAdapter);
    setOnItemClickListener(new CardGallery.1(this));
    setRecyclerListener(new CardGallery.2(this));
  }
  
  private void renderEmpty(boolean paramBoolean)
  {
    this.mAdapter.setCursor(null, paramBoolean);
    this.mAdapter.notifyDataSetChanged();
  }
  
  public boolean checkClickTremble()
  {
    if (this.clickTremble) {
      return true;
    }
    this.clickTremble = true;
    Threads.runInBackground(new CardGallery.3(this), 200L);
    return false;
  }
  
  public QMCardData getSelectedItem()
  {
    return this.mAdapter.getItem(getSelectedItemPosition());
  }
  
  public void render(QMCardListCursor paramQMCardListCursor, boolean paramBoolean)
  {
    Log.d("CardGallery", "CardGallery#render: " + paramQMCardListCursor.getCount());
    if (paramQMCardListCursor.getCount() == 0)
    {
      renderEmpty(paramBoolean);
      return;
    }
    this.mAdapter.setCursor(paramQMCardListCursor, paramBoolean);
    this.mAdapter.notifyDataSetChanged();
  }
  
  public void setCardHandler(CardHandler paramCardHandler)
  {
    this.mCardHandler = paramCardHandler;
    if (this.mAdapter != null) {
      this.mAdapter.setCardHandler(paramCardHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CardGallery
 * JD-Core Version:    0.7.0.1
 */