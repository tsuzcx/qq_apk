package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;
import pmi;
import pxs;
import pxs.b;
import ram;
import rom;

public class StoryNickNameView
  extends TextView
  implements IEventReceiver
{
  private a a;
  private boolean aDA;
  private boolean aJE;
  private LruCache<String, QQUserUIItem> k;
  private String mFormat;
  private String mUnionId;
  
  public StoryNickNameView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryNickNameView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public StoryNickNameView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void bwj()
  {
    ram.w("Q.qqstoryStoryNickNameView", "requestUserInfoAsync : " + this.mUnionId);
    QQUserUIItem.a locala = new QQUserUIItem.a("", this.mUnionId);
    pxs localpxs = new pxs();
    localpxs.mContext = "Q.qqstoryStoryNickNameView";
    localpxs.a(1, locala, this.mUnionId);
  }
  
  private void e(QQUserUIItem paramQQUserUIItem)
  {
    this.k.put(paramQQUserUIItem.getUnionId(), paramQQUserUIItem);
  }
  
  private QQUserUIItem f(String paramString)
  {
    return (QQUserUIItem)this.k.get(paramString);
  }
  
  private void init()
  {
    this.a = new a(this);
    this.aJE = false;
  }
  
  public void c(LruCache<String, QQUserUIItem> paramLruCache)
  {
    rom.checkNotNull(paramLruCache);
    this.k = paramLruCache;
  }
  
  protected void f(QQUserUIItem paramQQUserUIItem)
  {
    rom.checkNotNull(paramQQUserUIItem);
    ram.w("Q.qqstoryStoryNickNameView", "onInfoRespond " + this.mUnionId + " name = " + paramQQUserUIItem.getDisplayName());
    String str = paramQQUserUIItem.getDisplayName();
    if (!TextUtils.isEmpty(this.mFormat)) {
      str = String.format(this.mFormat, new Object[] { paramQQUserUIItem.getDisplayName() });
    }
    setText(str);
  }
  
  public String getUnionId()
  {
    return this.mUnionId;
  }
  
  public boolean isValidate()
  {
    return this.aDA;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    pmi.a().registerSubscriber(this.a);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    pmi.a().unRegisterSubscriber(this.a);
  }
  
  public void setFormat(String paramString)
  {
    this.mFormat = paramString;
  }
  
  public void setUnionId(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      setVisibility(8);
      this.mUnionId = "";
      this.aDA = false;
      return;
    }
    if (this.k != null) {}
    for (boolean bool = true;; bool = false)
    {
      rom.assertTrue(bool, "it must prepare this view before setUnionId!!");
      setVisibility(0);
      this.aDA = true;
      if (TextUtils.equals(this.mUnionId, paramString)) {
        break;
      }
      this.mUnionId = paramString;
      setText("");
      paramString = f(this.mUnionId);
      if (paramString != null) {
        break label95;
      }
      bwj();
      return;
    }
    label95:
    f(paramString);
  }
  
  static class a
    extends QQUIEventReceiver<StoryNickNameView, pxs.b>
  {
    public a(@NonNull StoryNickNameView paramStoryNickNameView)
    {
      super();
    }
    
    public void a(@NonNull StoryNickNameView paramStoryNickNameView, @NonNull pxs.b paramb)
    {
      if ((paramb.b != null) && (paramb.b.isFail())) {}
      do
      {
        return;
        if ((paramb.mX == null) || (paramb.mX.size() == 0))
        {
          ram.e("Q.qqstoryStoryNickNameView", "we receiver the error info form GetUserInfoHandler!!");
          return;
        }
        if (TextUtils.equals(paramb.context, "Q.qqstoryStoryNickNameView")) {
          StoryNickNameView.a(paramStoryNickNameView, (QQUserUIItem)paramb.mX.get(0));
        }
      } while (!TextUtils.equals(paramb.key, paramStoryNickNameView.getUnionId()));
      paramStoryNickNameView.f((QQUserUIItem)paramb.mX.get(0));
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryNickNameView
 * JD-Core Version:    0.7.0.1
 */