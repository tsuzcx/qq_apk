package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.widget.ProgressCircle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class DragSortAdapter
  extends BaseAdapter
{
  private static final String DOWN = "down";
  private static final String UPDATE = "update";
  public static final String VIPOpen = "MyEmosomAdapter";
  Handler handler;
  private LruCache mCache = new LruCache(30);
  protected Context mContext;
  protected List mData;
  private Drawable mDefaultIcon;
  private HashMap mDownListener;
  private boolean mIsEdited;
  private Object mLock = new Object();
  private boolean mNotifyOnChange;
  private HashMap mSelectStatus = new HashMap();
  private HashMap mUpdateListener;
  JSONArray mWordingList;
  private String type = "";
  
  public DragSortAdapter(Context paramContext, List paramList)
  {
    this.mContext = paramContext;
    this.mData = paramList;
    this.mDefaultIcon = this.mContext.getResources().getDrawable(2130837692);
    this.mWordingList = ClubContentJsonTask.a((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime());
    this.handler = new Handler();
    this.mUpdateListener = new HashMap();
    this.mDownListener = new HashMap();
  }
  
  private void download(EmoticonPackage paramEmoticonPackage, View paramView1, ProgressCircle paramProgressCircle, View paramView2)
  {
    paramView1 = (QQAppInterface)((BaseActivity)this.mContext).getAppRuntime();
    if (paramEmoticonPackage != null)
    {
      ((EmojiManager)paramView1.getManager(39)).a(paramEmoticonPackage, true);
      paramView2.setVisibility(8);
      paramProgressCircle.setVisibility(0);
    }
  }
  
  private EmoticonPackageDownloadListener getDownListener(EmoticonPackage paramEmoticonPackage, View paramView, ProgressCircle paramProgressCircle, ImageView paramImageView)
  {
    return new DragSortAdapter.4(this, paramEmoticonPackage, paramProgressCircle, paramView);
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
    return new DragSortAdapter.3(this, paramEmoticonPackage, paramProgressCircle, paramView1);
  }
  
  private View.OnClickListener getOnClickListener(EmoticonPackage paramEmoticonPackage, View paramView, ProgressCircle paramProgressCircle, Button paramButton)
  {
    return new DragSortAdapter.2(this, paramButton, paramEmoticonPackage, paramProgressCircle, paramView);
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
      paramViewGroup = View.inflate(this.mContext, 2130903197, null);
    }
    paramViewGroup.setVisibility(0);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(2131296544);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(2131297120);
    ImageView localImageView3 = (ImageView)paramViewGroup.findViewById(2131296286);
    Object localObject2 = (ImageView)paramViewGroup.findViewById(2131297121);
    ((ImageView)localObject2).setVisibility(8);
    View localView2 = paramViewGroup.findViewById(2131296441);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.mData.get(paramInt);
    View localView1 = paramViewGroup.findViewById(2131297125);
    localView1.setTag(localEmoticonPackage.epId);
    Object localObject3 = (Button)paramViewGroup.findViewById(2131297085);
    localView1.post(new DragSortAdapter.1(this, (Button)localObject3));
    ProgressCircle localProgressCircle = (ProgressCircle)paramViewGroup.findViewById(2131297126);
    ((Button)localObject3).setOnClickListener(getOnClickListener((EmoticonPackage)this.mData.get(paramInt), localView1, localProgressCircle, (Button)localObject3));
    paramView = ClubContentJsonTask.a(this.mWordingList, localEmoticonPackage.wordingId, localEmoticonPackage.expiretime);
    Object localObject1;
    if (localEmoticonPackage.valid)
    {
      ((Button)localObject3).setText(2131364043);
      EmojiManager localEmojiManager = (EmojiManager)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(39);
      float f = localEmojiManager.a(localEmoticonPackage.epId);
      if (f >= 0.0F) {
        if (EmoticonUtils.a(localEmoticonPackage))
        {
          ((Button)localObject3).setText(2131364043);
          localView1.setVisibility(0);
          ((Button)localObject3).setVisibility(8);
          localProgressCircle.setVisibility(0);
          localProgressCircle.setProgress((int)(f * 100.0F));
          if ("".equals(localEmoticonPackage.updateTip)) {
            break label1009;
          }
          paramView = localEmoticonPackage.updateTip;
          if (this.mIsEdited) {
            localView1.setVisibility(8);
          }
          localObject1 = paramView;
          if (EmoticonUtils.a((EmoticonPackage)this.mData.get(paramInt)))
          {
            ((Button)localObject3).setText(2131364043);
            if (this.mUpdateListener.get(localEmoticonPackage.epId) != null)
            {
              localObject1 = (EmoticonPackageDownloadListener)this.mUpdateListener.get(localEmoticonPackage.epId);
              localEmojiManager.a.b((EmoticonPackageDownloadListener)localObject1);
              this.mUpdateListener.remove(localEmoticonPackage.epId);
            }
            localObject1 = getEmoticonDownloadListener(localEmoticonPackage, localView1, localProgressCircle, (View)localObject2);
            this.mDownListener.put(localEmoticonPackage.epId, localObject1);
            localEmojiManager.a.a((EmoticonPackageDownloadListener)localObject1);
            localObject1 = paramView;
          }
          label471:
          localView2.setVisibility(8);
          if (this.mIsEdited) {
            break label1048;
          }
          localImageView2.setVisibility(8);
          localImageView3.setVisibility(8);
          if ((localEmoticonPackage.valid) && (localEmoticonPackage.status != 2))
          {
            localView1.setVisibility(0);
            ((Button)localObject3).setVisibility(0);
            ((Button)localObject3).setText(2131364044);
            paramView = (EmojiManager)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(39);
            f = paramView.a(localEmoticonPackage.epId);
            if (f < 0.0F) {
              break label1032;
            }
            ((Button)localObject3).setVisibility(8);
            localProgressCircle.setVisibility(0);
            localProgressCircle.setProgress((int)(f * 100.0F));
            label601:
            if (this.mDownListener.get(localEmoticonPackage.epId) != null)
            {
              localObject3 = (EmoticonPackageDownloadListener)this.mDownListener.get(localEmoticonPackage.epId);
              paramView.a.b((EmoticonPackageDownloadListener)localObject3);
              this.mDownListener.remove(localEmoticonPackage.epId);
            }
            localObject2 = getDownListener(localEmoticonPackage, localView1, localProgressCircle, (ImageView)localObject2);
            this.mDownListener.put(localEmoticonPackage.epId, localObject2);
            paramView.a.a((EmoticonPackageDownloadListener)localObject2);
          }
          ((TextView)paramViewGroup.findViewById(2131297123)).setText(localEmoticonPackage.name);
          localImageView1.setImageDrawable(getEPIcon(localEmoticonPackage));
          paramView = (ImageView)paramViewGroup.findViewById(2131296545);
          if (localEmoticonPackage.hasSound != true) {
            break label1094;
          }
          paramView.setVisibility(0);
          label747:
          paramView = (TextView)paramViewGroup.findViewById(2131297124);
          long l = new Date().getTime() / 1000L;
          if ((localEmoticonPackage.expiretime <= l) || ((localEmoticonPackage.expiretime - l) / 86400L >= 1L)) {
            break label1103;
          }
          paramView.setText((CharSequence)localObject1, TextView.BufferType.EDITABLE);
          paramView.getEditableText().setSpan(new ForegroundColorSpan(-65536), 0, ((String)localObject1).length(), 18);
        }
      }
    }
    for (;;)
    {
      if (this.mIsEdited)
      {
        if (!getSelectStatus(paramInt))
        {
          paramViewGroup.setContentDescription(this.mContext.getString(2131364039) + " " + localEmoticonPackage.name + "," + (String)localObject1);
          return paramViewGroup;
          localView1.setVisibility(8);
          localProgressCircle.setVisibility(8);
          if (this.mIsEdited)
          {
            break;
            if (EmoticonUtils.a(localEmoticonPackage))
            {
              ((Button)localObject3).setText(2131364043);
              localView1.setVisibility(0);
              ((Button)localObject3).setVisibility(0);
              localProgressCircle.setVisibility(8);
              if ("".equals(localEmoticonPackage.updateTip)) {
                break label1009;
              }
              paramView = localEmoticonPackage.updateTip;
              break;
            }
            localView1.setVisibility(8);
            localProgressCircle.setVisibility(8);
            if (!this.mIsEdited) {}
          }
          label1009:
          break;
          localView1.setVisibility(8);
          if (this.mIsEdited) {}
          localObject1 = paramView;
          break label471;
          label1032:
          ((Button)localObject3).setVisibility(0);
          localProgressCircle.setVisibility(8);
          break label601;
          label1048:
          boolean bool = getSelectStatus(paramInt);
          localImageView2.setVisibility(0);
          if (bool) {
            localImageView2.setImageResource(2130838997);
          }
          for (;;)
          {
            localImageView3.setVisibility(0);
            break;
            localImageView2.setImageResource(2130838996);
          }
          label1094:
          paramView.setVisibility(8);
          break label747;
          label1103:
          paramView.setText((CharSequence)localObject1);
          continue;
        }
        paramViewGroup.setContentDescription(this.mContext.getString(2131364040) + " " + localEmoticonPackage.name + "," + (String)localObject1);
        return paramViewGroup;
      }
    }
    paramViewGroup.setContentDescription(localEmoticonPackage.name + "," + (String)localObject1);
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
        this.mDownListener.remove(localEmoticonPackage.epId);
      }
      this.mData.remove(paramObject);
      if (this.mNotifyOnChange) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void removeDownloadListeners()
  {
    EmojiManager localEmojiManager = (EmojiManager)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(39);
    int i = 0;
    while (i < this.mData.size())
    {
      localEmojiManager.a.b((EmoticonPackageDownloadListener)this.mDownListener.get(((EmoticonPackage)this.mData.get(i)).epId));
      i += 1;
    }
  }
  
  public void removeUpdateListeners()
  {
    EmojiManager localEmojiManager = (EmojiManager)((QQAppInterface)((BaseActivity)this.mContext).getAppRuntime()).getManager(39);
    int i = 0;
    while (i < this.mData.size())
    {
      localEmojiManager.a.b((EmoticonPackageDownloadListener)this.mUpdateListener.get(((EmoticonPackage)this.mData.get(i)).epId));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter
 * JD-Core Version:    0.7.0.1
 */