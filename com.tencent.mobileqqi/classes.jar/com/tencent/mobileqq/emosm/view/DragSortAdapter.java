package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.EmoticonWording;
import com.tencent.mobileqq.widget.ProgressCircle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class DragSortAdapter
  extends BaseAdapter
{
  private Handler handler;
  private LruCache mCache = new LruCache(30);
  public Context mContext;
  public List mData;
  private Drawable mDefaultIcon;
  private EmoticonWording mEmoticonWording;
  private boolean mIsEdited;
  private Object mLock = new Object();
  private boolean mNotifyOnChange;
  private HashMap mSelectStatus = new HashMap();
  private HashMap mUpdateListener;
  
  public DragSortAdapter(Context paramContext, List paramList)
  {
    this.mContext = paramContext;
    this.mData = paramList;
    this.mDefaultIcon = null;
    this.mEmoticonWording = new EmoticonWording(this.mContext);
    this.handler = new Handler();
    this.mUpdateListener = new HashMap();
  }
  
  private Drawable getEPIcon(EmoticonPackage paramEmoticonPackage)
  {
    if (this.mCache.get(paramEmoticonPackage.epId) != null) {
      return (Drawable)this.mCache.get(paramEmoticonPackage.epId);
    }
    Object localObject = EmosmUtils.getCoverBitmap(2, paramEmoticonPackage.epId);
    if (localObject != null)
    {
      localObject = new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject);
      this.mCache.put(paramEmoticonPackage.epId, localObject);
      return localObject;
    }
    return this.mDefaultIcon;
  }
  
  private EmoticonPackageDownloadListener getEmoticonDownloadListener(EmoticonPackage paramEmoticonPackage, View paramView1, ProgressCircle paramProgressCircle, View paramView2)
  {
    return new DragSortAdapter.2(this, paramEmoticonPackage, paramProgressCircle, paramView1, paramView2);
  }
  
  private View.OnClickListener getOnClickListener(EmoticonPackage paramEmoticonPackage, View paramView, ProgressCircle paramProgressCircle)
  {
    return new DragSortAdapter.1(this, paramEmoticonPackage, paramProgressCircle);
  }
  
  public void clearCache()
  {
    this.mCache.evictAll();
  }
  
  public void clearSelectStatus()
  {
    this.mSelectStatus.clear();
  }
  
  public int getCount()
  {
    if (this.mData == null) {
      return 0;
    }
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mData.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public boolean getSelectStatus(int paramInt)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    if (this.mSelectStatus.containsKey(localEmoticonPackage)) {
      return ((Boolean)this.mSelectStatus.get(localEmoticonPackage)).booleanValue();
    }
    return false;
  }
  
  public List getSelectedPackages()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mSelectStatus.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.mContext, 2130903233, null);
    }
    paramViewGroup.setVisibility(0);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(2131231102);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(2131231693);
    ImageView localImageView3 = (ImageView)paramViewGroup.findViewById(2131230761);
    ImageView localImageView4 = (ImageView)paramViewGroup.findViewById(2131231694);
    View localView1 = paramViewGroup.findViewById(2131230987);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.mData.get(paramInt);
    View localView2 = paramViewGroup.findViewById(2131231698);
    Object localObject = (Button)paramViewGroup.findViewById(2131231648);
    ProgressCircle localProgressCircle = (ProgressCircle)paramViewGroup.findViewById(2131231699);
    paramView = this.mEmoticonWording.a(localEmoticonPackage.wordingId, localEmoticonPackage.expiretime);
    if (localEmoticonPackage.valid)
    {
      ((Button)localObject).setOnClickListener(getOnClickListener((EmoticonPackage)this.mData.get(paramInt), localView2, localProgressCircle));
      QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.mContext).getAppRuntime();
      float f = EmoticonController.a(localQQAppInterface).a(localEmoticonPackage.epId);
      if (f >= 0.0F) {
        if (EmoticonUtils.a(localEmoticonPackage))
        {
          localImageView4.setVisibility(8);
          localView2.setVisibility(0);
          ((Button)localObject).setVisibility(8);
          localProgressCircle.setVisibility(0);
          localProgressCircle.setProgress((int)(100.0F * f));
          if (!"".equals(localEmoticonPackage.updateTip)) {
            paramView = localEmoticonPackage.updateTip;
          }
          if (this.mIsEdited) {
            localView2.setVisibility(8);
          }
          localObject = paramView;
          if (EmoticonUtils.a((EmoticonPackage)this.mData.get(paramInt)))
          {
            if (this.mUpdateListener.get(localEmoticonPackage.epId) == null) {
              break label667;
            }
            localObject = (EmoticonPackageDownloadListener)this.mUpdateListener.get(localEmoticonPackage.epId);
            label342:
            EmoticonController.a(localQQAppInterface).a((EmoticonPackageDownloadListener)localObject);
            localObject = paramView;
          }
          label355:
          localView1.setVisibility(8);
          if (this.mIsEdited) {
            break label738;
          }
          localImageView2.setVisibility(8);
          localImageView3.setVisibility(8);
          ((TextView)paramViewGroup.findViewById(2131231696)).setText(localEmoticonPackage.name);
          localImageView1.setImageDrawable(getEPIcon(localEmoticonPackage));
          paramView = (ImageView)paramViewGroup.findViewById(2131231103);
          if (localEmoticonPackage.hasSound != true) {
            break label784;
          }
          paramView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      paramView = (TextView)paramViewGroup.findViewById(2131231697);
      long l = new Date().getTime() / 1000L;
      if ((localEmoticonPackage.expiretime <= l) || ((localEmoticonPackage.expiretime - l) / 86400L >= 1L)) {
        break label793;
      }
      paramView.setText((CharSequence)localObject, TextView.BufferType.EDITABLE);
      paramView.getEditableText().setSpan(new ForegroundColorSpan(-65536), 0, ((String)localObject).length(), 18);
      return paramViewGroup;
      localView2.setVisibility(8);
      localProgressCircle.setVisibility(8);
      if (this.mIsEdited)
      {
        localImageView4.setVisibility(8);
        break;
      }
      localImageView4.setVisibility(0);
      break;
      if (EmoticonUtils.a(localEmoticonPackage))
      {
        localImageView4.setVisibility(8);
        localView2.setVisibility(0);
        ((Button)localObject).setVisibility(0);
        localProgressCircle.setVisibility(8);
        if ("".equals(localEmoticonPackage.updateTip)) {
          break;
        }
        paramView = localEmoticonPackage.updateTip;
        break;
      }
      localView2.setVisibility(8);
      localProgressCircle.setVisibility(8);
      if (this.mIsEdited)
      {
        localImageView4.setVisibility(8);
        break;
      }
      localImageView4.setVisibility(0);
      break;
      label667:
      localObject = getEmoticonDownloadListener(localEmoticonPackage, localView2, localProgressCircle, localImageView4);
      this.mUpdateListener.put(localEmoticonPackage.epId, localObject);
      break label342;
      localView2.setVisibility(8);
      if (this.mIsEdited)
      {
        localImageView4.setVisibility(8);
        localObject = paramView;
        break label355;
      }
      localImageView4.setVisibility(0);
      localObject = paramView;
      break label355;
      label738:
      boolean bool = getSelectStatus(paramInt);
      localImageView2.setVisibility(0);
      if (bool) {
        localImageView2.setImageResource(2130840217);
      }
      for (;;)
      {
        localImageView3.setVisibility(0);
        break;
        localImageView2.setImageResource(2130840218);
      }
      label784:
      paramView.setVisibility(8);
    }
    label793:
    paramView.setText((CharSequence)localObject);
    return paramViewGroup;
  }
  
  public void insert(Object paramObject, int paramInt)
  {
    synchronized (this.mLock)
    {
      this.mData.add(paramInt, paramObject);
      if (this.mNotifyOnChange) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.mNotifyOnChange = true;
  }
  
  public void remove(Object paramObject)
  {
    synchronized (this.mLock)
    {
      if ((paramObject instanceof EmoticonPackage))
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramObject;
        this.mUpdateListener.remove(localEmoticonPackage.epId);
      }
      this.mData.remove(paramObject);
      if (this.mNotifyOnChange) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void removeUpdateListeners()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.mContext).getAppRuntime();
    int i = 0;
    while (i < this.mData.size())
    {
      EmoticonController.a(localQQAppInterface).b((EmoticonPackageDownloadListener)this.mUpdateListener.get(((EmoticonPackage)this.mData.get(i)).epId));
      i += 1;
    }
  }
  
  public void setEditMode(boolean paramBoolean)
  {
    this.mIsEdited = paramBoolean;
  }
  
  public void setNotifyOnChange(boolean paramBoolean)
  {
    this.mNotifyOnChange = paramBoolean;
  }
  
  public void setSelected(int paramInt)
  {
    boolean bool = getSelectStatus(paramInt);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    HashMap localHashMap = this.mSelectStatus;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localHashMap.put(localEmoticonPackage, Boolean.valueOf(bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter
 * JD-Core Version:    0.7.0.1
 */