package com.tencent.mobileqq.widget;

import aagd;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimationView
  extends RoundImageView
{
  protected Player a;
  protected AnimationInfo b;
  protected MyAnimationListener b;
  
  public AnimationView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public AnimationInfo getAnimationFromInfo()
  {
    return this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
  }
  
  public Player getPlayer()
  {
    return this.a;
  }
  
  public void pause()
  {
    if (this.a == null) {
      return;
    }
    this.a.pause();
  }
  
  public void play()
  {
    if (this.a == null) {
      return;
    }
    this.a.play();
  }
  
  public void resume()
  {
    if (this.a == null) {
      return;
    }
    this.a.resume();
  }
  
  public void setAnimationFromBitmaps(ArrayList<Bitmap> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(new BitmapDrawable(getResources(), (Bitmap)paramArrayList.get(i)));
      i += 1;
    }
    setAnimationFromDrawabs(localArrayList, paramInt1, paramInt2);
  }
  
  public void setAnimationFromDrawabs(ArrayList<Drawable> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0) || (paramInt1 <= 0)) {}
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = AnimationInfo.loadFromFrames(paramArrayList, paramInt1, paramInt2);
    } while (this.a != null);
    this.a = new Player(this);
  }
  
  public void setAnimationFromDrawabs(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfDrawable == null) || (paramArrayOfDrawable.length <= 0) || (paramInt1 <= 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfDrawable.length)
    {
      localArrayList.add(paramArrayOfDrawable[i]);
      i += 1;
    }
    setAnimationFromDrawabs(localArrayList, paramInt1, paramInt2);
  }
  
  public void setAnimationFromInfo(AnimationInfo paramAnimationInfo)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = paramAnimationInfo;
    if (this.a == null) {
      this.a = new Player(this);
    }
  }
  
  public void setAnimationListener(MyAnimationListener paramMyAnimationListener)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener = paramMyAnimationListener;
  }
  
  public void setPlayer(Player paramPlayer)
  {
    this.a = paramPlayer;
  }
  
  public void stop()
  {
    if (this.a == null) {
      return;
    }
    this.a.stop();
  }
  
  public static class AnimationInfo
  {
    public static final int DEFAULT_FRAME_RATE = 100;
    public static final int ZIP_STATE_EMPTY_ZIP = 4;
    public static final int ZIP_STATE_NOT_EXIST = 2;
    public static final int ZIP_STATE_NO_IMAGE_FILE = 5;
    public static final int ZIP_STATE_UNZIP_FAILURE = 3;
    public static final int ZIP_STATE_VALID = 1;
    public int mCycle;
    public int mDelay;
    public SparseArray<Drawable> mFrames = new SparseArray();
    public int mInfiniteFromInOnCycle = -1;
    public int mInfiniteToInOnCycle = -1;
    public int mInterval;
    public ArrayList<Integer> mOneCycleFrames = new ArrayList();
    public ArrayList<AnimationView.PlayItem> mPlay = new ArrayList();
    
    public AnimationInfo()
    {
      this.mCycle = 0;
      this.mInterval = 100;
      this.mDelay = 100;
      this.mInfiniteFromInOnCycle = -1;
      this.mInfiniteToInOnCycle = -1;
    }
    
    public AnimationInfo(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mCycle = paramInt1;
      this.mInterval = paramInt2;
      this.mDelay = paramInt3;
      if (this.mInterval <= 0) {
        this.mInterval = 100;
      }
      if (this.mDelay <= 0) {
        this.mDelay = 100;
      }
      this.mInfiniteFromInOnCycle = -1;
      this.mInfiniteToInOnCycle = -1;
    }
    
    protected static AnimationInfo a(File paramFile)
    {
      if ((paramFile == null) || (!paramFile.exists())) {}
      do
      {
        return null;
        try
        {
          paramFile = aqhq.e(paramFile);
          if (paramFile == null) {
            break;
          }
          paramFile = new String(paramFile, "UTF-8");
        }
        catch (Exception paramFile)
        {
          for (;;)
          {
            paramFile.printStackTrace();
            paramFile = null;
          }
        }
      } while (TextUtils.isEmpty(paramFile));
      return a(paramFile);
    }
    
    protected static AnimationInfo a(String paramString)
    {
      int i = 0;
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      for (;;)
      {
        try
        {
          Object localObject = new JSONObject(paramString);
          int j = ((JSONObject)localObject).optInt("cycle", 0);
          int k = ((JSONObject)localObject).optInt("interval", 100);
          int m = ((JSONObject)localObject).optInt("delay", 100);
          paramString = new ArrayList();
          localObject = ((JSONObject)localObject).optJSONArray("play");
          if ((localObject != null) && (i < ((JSONArray)localObject).length()))
          {
            AnimationView.PlayItem localPlayItem = AnimationView.PlayItem.a(((JSONArray)localObject).getJSONObject(i));
            if (localPlayItem != null) {
              paramString.add(localPlayItem);
            }
          }
          else
          {
            if (paramString.size() <= 0) {
              break;
            }
            localObject = new AnimationInfo(j, k, m);
            ((AnimationInfo)localObject).mPlay = paramString;
            ((AnimationInfo)localObject).ehK();
            return localObject;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return null;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
          return null;
        }
        i += 1;
      }
    }
    
    protected static int ft(String paramString)
    {
      int i = 0;
      if (!new File(paramString).exists()) {
        return 2;
      }
      String str = paramString + "Folder";
      File localFile = new File(str);
      if ((!localFile.exists()) && (!aagd.unzipAtomically(paramString, str))) {
        return 3;
      }
      paramString = localFile.listFiles();
      if ((paramString == null) || (paramString.length <= 0))
      {
        aqhq.delete(str, false);
        return 4;
      }
      do
      {
        i += 1;
        if (i >= paramString.length) {
          break;
        }
      } while ((paramString[i] == null) || (!paramString[i].isFile()) || (!aqhq.rr(paramString[i].getAbsolutePath())));
      return 1;
      return 5;
    }
    
    public static AnimationInfo loadFromFolder(String paramString)
    {
      int m = 0;
      int k = 0;
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Object localObject = new File(paramString, "play.cfg");
      if (((File)localObject).exists()) {}
      for (localObject = a((File)localObject);; localObject = null)
      {
        if (localObject != null) {}
        for (ArrayList localArrayList1 = ((AnimationInfo)localObject).getFrames();; localArrayList1 = null)
        {
          if ((localObject == null) || (localArrayList1 == null) || (localArrayList1.size() <= 0))
          {
            paramString = aagd.a(paramString);
            if ((paramString == null) || (paramString.length <= 0)) {
              return null;
            }
            localObject = new ArrayList();
            i = 0;
            while (i < paramString.length)
            {
              ((ArrayList)localObject).add(paramString[i]);
              i += 1;
            }
            return loadFromFrames((ArrayList)localObject, 100, 100);
          }
          paramString = new File(paramString).listFiles();
          if ((paramString == null) || (paramString.length <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.e("AnimationView", 2, "nothing in unzip folder");
            }
            return null;
          }
          aagd.a(paramString);
          ArrayList localArrayList2 = new ArrayList();
          int i = 0;
          while (i < paramString.length)
          {
            if ((paramString[i] != null) && (paramString[i].isFile()) && (aqhq.rr(paramString[i].getAbsolutePath()))) {
              localArrayList2.add(paramString[i]);
            }
            i += 1;
          }
          SparseArray localSparseArray = new SparseArray();
          int j = 0;
          i = 0;
          if (j < localArrayList2.size())
          {
            if (!localArrayList1.contains(Integer.valueOf(j + 1))) {}
            for (;;)
            {
              j += 1;
              break;
              try
              {
                paramString = new BitmapDrawable(((File)localArrayList2.get(j)).getAbsolutePath());
                if ((i == 0) && (paramString != null) && (paramString.getBitmap() != null)) {
                  break label425;
                }
                i = k;
                if (QLog.isColorLevel())
                {
                  QLog.e("AnimationView", 2, "decode fail till" + ((File)localArrayList2.get(j)).getAbsolutePath());
                  i = k;
                }
                while (i < localSparseArray.size())
                {
                  aagd.f((Drawable)localSparseArray.valueAt(i));
                  i += 1;
                }
              }
              catch (OutOfMemoryError paramString)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("AnimationView", 2, "decode fail - OutOfMemoryError" + paramString);
                  }
                  i = 1;
                  paramString = null;
                }
              }
              return null;
              label425:
              localSparseArray.append(j + 1, paramString);
            }
          }
          if (localArrayList1.size() != localSparseArray.size())
          {
            i = m;
            while (i < localSparseArray.size())
            {
              aagd.f((Drawable)localSparseArray.valueAt(i));
              i += 1;
            }
            return null;
          }
          ((AnimationInfo)localObject).mFrames = localSparseArray;
          return localObject;
        }
      }
    }
    
    public static AnimationInfo loadFromFrames(ArrayList<Drawable> paramArrayList, int paramInt1, int paramInt2)
    {
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        return null;
      }
      AnimationInfo localAnimationInfo = new AnimationInfo(paramInt2, paramInt1, paramInt1);
      paramInt1 = 0;
      while (paramInt1 < paramArrayList.size())
      {
        localAnimationInfo.mPlay.add(new AnimationView.PlayItem(paramInt1 + 1));
        localAnimationInfo.mFrames.append(paramInt1 + 1, paramArrayList.get(paramInt1));
        paramInt1 += 1;
      }
      localAnimationInfo.ehK();
      return localAnimationInfo;
    }
    
    public static AnimationInfo loadFromZip(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      while (ft(paramString) != 1) {
        return null;
      }
      return loadFromFolder(paramString + "Folder");
    }
    
    public void destoryBitmaps()
    {
      int i = 0;
      while (i < this.mFrames.size())
      {
        aagd.f((Drawable)this.mFrames.valueAt(i));
        i += 1;
      }
      this.mFrames.clear();
    }
    
    protected void ehK()
    {
      this.mInfiniteFromInOnCycle = -1;
      this.mInfiniteToInOnCycle = -1;
      this.mOneCycleFrames.clear();
      int i = 0;
      if (i < this.mPlay.size())
      {
        AnimationView.PlayItem localPlayItem = (AnimationView.PlayItem)this.mPlay.get(i);
        if (localPlayItem != null)
        {
          if (localPlayItem.mFrame <= 0) {
            break label79;
          }
          this.mOneCycleFrames.add(Integer.valueOf(localPlayItem.mFrame));
        }
        label79:
        do
        {
          do
          {
            i += 1;
            break;
          } while ((localPlayItem.mFrom <= 0) || (localPlayItem.mTo <= 0) || (localPlayItem.mTo <= localPlayItem.mFrom));
          int k = localPlayItem.mCycle;
          int j = k;
          if (k <= 0) {
            j = 1;
          }
          k = 0;
          while (k < j)
          {
            int m = localPlayItem.mFrom;
            while (m < localPlayItem.mTo + 1)
            {
              this.mOneCycleFrames.add(Integer.valueOf(m));
              m += 1;
            }
            k += 1;
          }
        } while (localPlayItem.mCycle != 0);
        this.mInfiniteFromInOnCycle = localPlayItem.mFrom;
        this.mInfiniteToInOnCycle = localPlayItem.mTo;
      }
    }
    
    protected ArrayList<Integer> getFrames()
    {
      ArrayList localArrayList = new ArrayList();
      if ((this.mPlay != null) && (this.mPlay.size() > 0))
      {
        int i = 0;
        while (i < this.mPlay.size())
        {
          Object localObject = (AnimationView.PlayItem)this.mPlay.get(i);
          if (localObject != null)
          {
            localObject = ((AnimationView.PlayItem)localObject).getFrames();
            int j = 0;
            while (j < ((ArrayList)localObject).size())
            {
              if (!localArrayList.contains(((ArrayList)localObject).get(j))) {
                localArrayList.add(((ArrayList)localObject).get(j));
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
      return localArrayList;
    }
  }
  
  public static abstract interface MyAnimationListener
  {
    public abstract void onAnimationEnd(AnimationView paramAnimationView);
    
    public abstract void onAnimationRepeat(AnimationView paramAnimationView);
    
    public abstract void onAnimationStart(AnimationView paramAnimationView);
  }
  
  public static class PlayItem
  {
    public int mCycle;
    public int mFrame;
    public int mFrom;
    public int mTo;
    
    public PlayItem(int paramInt)
    {
      this.mFrame = paramInt;
    }
    
    public PlayItem(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mFrom = paramInt1;
      this.mTo = paramInt2;
      this.mCycle = paramInt3;
    }
    
    protected static PlayItem a(JSONObject paramJSONObject)
    {
      int i = 1;
      if (paramJSONObject == null) {
        return null;
      }
      int j = paramJSONObject.optInt("frame");
      if (j > 0) {
        return new PlayItem(j);
      }
      int k = paramJSONObject.optInt("from");
      int m = paramJSONObject.optInt("to");
      j = paramJSONObject.optInt("cycle", 1);
      if ((m > 0) && (k > 0) && (m > k)) {
        if (j >= 0) {
          break label84;
        }
      }
      for (;;)
      {
        return new PlayItem(k, m, i);
        return null;
        label84:
        i = j;
      }
    }
    
    public ArrayList<Integer> getFrames()
    {
      ArrayList localArrayList = new ArrayList();
      if (this.mFrame > 0) {
        localArrayList.add(Integer.valueOf(this.mFrame));
      }
      for (;;)
      {
        return localArrayList;
        if ((this.mTo > 0) && (this.mFrom > 0) && (this.mTo > this.mFrom))
        {
          int i = this.mFrom;
          while (i < this.mTo + 1)
          {
            localArrayList.add(Integer.valueOf(i));
            i += 1;
          }
        }
      }
    }
  }
  
  public static class Player
    implements Handler.Callback
  {
    public static final int MSG_PLAY = 1;
    final int STATE_PLAYING = 1;
    final int STATE_READY = 0;
    final int STATE_STOP = 2;
    int bIg = 0;
    boolean cZq = false;
    int eeS = 0;
    protected WeakReference<AnimationView> iE;
    protected Handler mHandler;
    int mState = 0;
    
    public Player(AnimationView paramAnimationView)
    {
      this.iE = new WeakReference(paramAnimationView);
      this.mHandler = new Handler(this);
    }
    
    protected Drawable a(AnimationView paramAnimationView)
    {
      if ((paramAnimationView == null) || (paramAnimationView.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo == null))
      {
        this.mState = 2;
        return null;
      }
      paramAnimationView = paramAnimationView.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      if (this.mState == 2) {
        return null;
      }
      if (paramAnimationView.mOneCycleFrames.size() <= 0)
      {
        this.mState = 2;
        return null;
      }
      if ((this.bIg < 0) || (this.bIg > paramAnimationView.mOneCycleFrames.size()))
      {
        this.mState = 2;
        return null;
      }
      int k = this.bIg + 1;
      int m = 0;
      int j = m;
      int i = k;
      if (paramAnimationView.mInfiniteFromInOnCycle > 0)
      {
        j = m;
        i = k;
        if (paramAnimationView.mInfiniteToInOnCycle > 0)
        {
          j = m;
          i = k;
          if (paramAnimationView.mInfiniteToInOnCycle > paramAnimationView.mInfiniteFromInOnCycle)
          {
            if (this.bIg != paramAnimationView.mInfiniteToInOnCycle) {
              break label285;
            }
            i = paramAnimationView.mInfiniteFromInOnCycle;
            j = 1;
          }
        }
      }
      for (;;)
      {
        if (i > paramAnimationView.mOneCycleFrames.size())
        {
          if (paramAnimationView.mCycle < 0) {}
          for (this.mState = 2; this.mState == 2; this.mState = 2)
          {
            label173:
            return null;
            if ((paramAnimationView.mCycle == 0) || (this.eeS < paramAnimationView.mCycle)) {
              break label173;
            }
          }
          k = 1;
        }
        for (;;)
        {
          this.bIg = k;
          i = ((Integer)paramAnimationView.mOneCycleFrames.get(k - 1)).intValue();
          return (Drawable)paramAnimationView.mFrames.get(i);
          k = i;
          if (i == paramAnimationView.mOneCycleFrames.size())
          {
            k = i;
            if (j == 0)
            {
              this.eeS += 1;
              k = i;
            }
          }
        }
        label285:
        j = 1;
        i = k;
      }
    }
    
    protected void dpN()
    {
      Object localObject = (AnimationView)this.iE.get();
      if ((localObject == null) || (this.mState == 2)) {
        return;
      }
      Drawable localDrawable = a((AnimationView)localObject);
      if (localDrawable != null) {
        ((AnimationView)localObject).setImageDrawable(localDrawable);
      }
      if (((AnimationView)localObject).jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener != null)
      {
        if ((this.bIg != 1) || (this.eeS <= 0)) {
          break label98;
        }
        ((AnimationView)localObject).jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener.onAnimationRepeat((AnimationView)localObject);
      }
      for (;;)
      {
        int i = getNextFrameDelay((AnimationView)localObject);
        localObject = this.mHandler.obtainMessage(1);
        this.mHandler.sendMessageDelayed((Message)localObject, i);
        return;
        label98:
        if ((this.bIg == 1) && (this.eeS == 0))
        {
          if (!this.cZq)
          {
            this.cZq = true;
            ((AnimationView)localObject).jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener.onAnimationStart((AnimationView)localObject);
          }
        }
        else if (this.mState == 2) {
          ((AnimationView)localObject).jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener.onAnimationEnd((AnimationView)localObject);
        }
      }
    }
    
    public int getNextFrameDelay(AnimationView paramAnimationView)
    {
      if ((paramAnimationView == null) || (paramAnimationView.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo == null)) {
        return 100;
      }
      if (this.bIg >= paramAnimationView.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo.mOneCycleFrames.size()) {
        return paramAnimationView.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo.mDelay;
      }
      return paramAnimationView.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo.mInterval;
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return false;
        dpN();
      }
    }
    
    public void pause()
    {
      stop();
    }
    
    public void play()
    {
      reset();
      this.mState = 1;
      dpN();
    }
    
    public void reset()
    {
      this.bIg = 0;
      this.eeS = 0;
      this.mState = 0;
      this.cZq = false;
    }
    
    public void resume()
    {
      AnimationView localAnimationView = (AnimationView)this.iE.get();
      if ((this.mState == 1) || (localAnimationView == null)) {}
      do
      {
        return;
        this.mState = 1;
        dpN();
      } while (localAnimationView.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener == null);
      localAnimationView.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView$MyAnimationListener.onAnimationStart(localAnimationView);
    }
    
    public void stop()
    {
      this.mState = 2;
      this.mHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView
 * JD-Core Version:    0.7.0.1
 */