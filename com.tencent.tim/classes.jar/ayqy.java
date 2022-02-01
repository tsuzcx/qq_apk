import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory.3;
import java.util.ArrayList;

public class ayqy
{
  protected ArrayList<String> Cj = new ArrayList();
  protected ayqy.a a;
  public int bte;
  public int btf;
  public LruCache<String, rrk> h = new LruCache(60);
  protected Context mContext;
  public Handler mUIHandler = new ayqz(this, Looper.getMainLooper());
  protected LruCache<String, String> q = new LruCache(120);
  private BroadcastReceiver w = new ayra(this);
  
  public ayqy(Context paramContext)
  {
    this.mContext = paramContext;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    paramContext.registerReceiver(this.w, localIntentFilter, "com.tencent.qim.qqhead.permission.getheadresp", null);
  }
  
  protected Bitmap B(Bitmap paramBitmap)
  {
    ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap start.");
    float f2 = this.mContext.getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < this.bte * f2) {
        f1 = i / this.bte;
      }
    }
    this.bte = ((int)(this.bte * f1));
    this.btf = ((int)(f1 * this.btf));
    i = this.bte;
    ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap end.");
    return aqhu.b(paramBitmap, i, this.bte, this.btf);
  }
  
  public void a(ayqy.a parama)
  {
    this.a = parama;
  }
  
  public Drawable b(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "getStoryFaceDrawable uin is null!");
      return null;
    }
    this.bte = paramInt1;
    this.btf = paramInt2;
    if (!TextUtils.isEmpty((CharSequence)this.q.get(paramString)))
    {
      localrrk = (rrk)this.h.get(paramString);
      if (localrrk != null)
      {
        ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "getStoryFaceDrawable, hit cache:" + paramString);
        return localrrk;
      }
    }
    ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "getStoryFaceDrawable, not in cache:" + paramString);
    rrk localrrk = new rrk(paramInt1, paramInt2);
    this.h.put(paramString, localrrk);
    Message localMessage = this.mUIHandler.obtainMessage(1000);
    localMessage.obj = paramString;
    localMessage.sendToTarget();
    return localrrk;
  }
  
  protected void co(String paramString)
  {
    ram.d("Q.qqstory.record.StoryFaceDrawableFactory", "sendQQHeadRequest uin:%s.", paramString);
    this.Cj.add(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new Intent("com.tencent.qqhead.getheadreq");
    paramString.setPackage(this.mContext.getPackageName());
    paramString.putExtra("faceType", 1);
    paramString.putStringArrayListExtra("uinList", localArrayList);
    this.mContext.sendBroadcast(paramString, "com.tencent.qim.qqhead.permission.getheadresp");
  }
  
  public void destroy()
  {
    ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "onDestory");
    try
    {
      this.mContext.unregisterReceiver(this.w);
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.Cj.clear();
      this.q.evictAll();
      this.h.evictAll();
      return;
    }
    catch (Exception localException)
    {
      ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "onDestory:" + localException.toString());
    }
  }
  
  protected void jW(String paramString1, String paramString2)
  {
    ThreadManager.post(new StoryFaceDrawableFactory.3(this, paramString2, paramString1), 8, null, true);
  }
  
  public Bitmap t(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "localPath = null!");
      return null;
    }
    ram.d("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath start. localPath:%s.", paramString);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString);
      if (paramString == null)
      {
        ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "BitmapFactory.decodeFile return null!");
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "BitmapFactory.decodeFile error : %s.", paramString);
        paramString = null;
      }
      Bitmap localBitmap = B(paramString);
      if (localBitmap == null)
      {
        ram.e("Q.qqstory.record.StoryFaceDrawableFactory", "getCircleFaceBitmap return null!");
        return null;
      }
      if ((paramString != null) && (!paramString.isRecycled())) {
        paramString.recycle();
      }
      ram.i("Q.qqstory.record.StoryFaceDrawableFactory", "getFaceBitmapByPath end.");
      return localBitmap;
    }
  }
  
  public static abstract interface a
  {
    public abstract void eRh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqy
 * JD-Core Version:    0.7.0.1
 */