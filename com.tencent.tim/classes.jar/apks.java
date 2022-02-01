import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class apks
  extends apku
{
  public long arF;
  public String cpQ;
  public String cpR;
  public ConcurrentHashMap<String, awjs.c> iM;
  public int mHeight;
  public String mImagePath;
  protected String mImageUrl;
  public int mMaxWidth;
  public int mProgress;
  public int mWidth;
  public URL n;
  
  public apks() {}
  
  public apks(String paramString)
  {
    SY(paramString);
    eay();
    this.cpR = String.valueOf(hashCode());
  }
  
  public apks(JSONObject paramJSONObject)
    throws JSONException
  {
    bN(paramJSONObject);
    this.cpR = String.valueOf(hashCode());
  }
  
  public static String Br()
  {
    VFSFile localVFSFile = new VFSFile(TroopHWJsPlugin.cQU);
    if (!localVFSFile.exists())
    {
      localVFSFile.mkdirs();
      aqhq.UD(TroopHWJsPlugin.cQU + ".nomedia");
    }
    return TroopHWJsPlugin.cQU;
  }
  
  public String Bq()
  {
    if (TextUtils.isEmpty(this.mImagePath)) {
      return this.mImageUrl;
    }
    return this.mImagePath;
  }
  
  public void SY(String paramString)
  {
    try
    {
      this.n = new File(paramString).toURI().toURL();
      this.mImagePath = paramString;
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ImageInfo", 1, "setURLFromPath exception.");
    }
  }
  
  public void SZ(String paramString)
  {
    try
    {
      this.n = new URL(paramString);
      this.mImageUrl = paramString;
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ImageInfo", 1, "Image setURLFromContentUrl exception.");
    }
  }
  
  public awjs.c a(String paramString1, String paramString2)
  {
    if (this.iM == null) {
      this.iM = new ConcurrentHashMap();
    }
    if (!this.iM.containsKey(paramString1))
    {
      paramString2 = new awjs.c(qem.getQQAppInterface(), paramString1, paramString2);
      this.iM.put(paramString1, paramString2);
      return paramString2;
    }
    return (awjs.c)this.iM.get(paramString1);
  }
  
  public Stream<apks> a(XMediaEditor paramXMediaEditor)
  {
    this.mUploadStatus = 1;
    Object localObject2 = Stream.of(this).map(new ThreadOffFunction("ImageInfo", 2));
    Object localObject1 = localObject2;
    if (!ahbj.fileExistsAndNotEmpty(this.cpQ)) {
      localObject1 = ((Stream)localObject2).map(new apks.a(this.mMaxWidth));
    }
    if (TextUtils.isEmpty(this.mImageUrl)) {
      localObject1 = ((Stream)localObject1).map(new apks.b(0, paramXMediaEditor, paramXMediaEditor.oG("troopuin")));
    }
    for (;;)
    {
      localObject2 = paramXMediaEditor.findViewHolderForLayoutPosition(this.mPosition);
      if ((localObject2 instanceof aple.a))
      {
        localObject2 = (aple.a)localObject2;
        if (this.cpR.equals(((aple.a)localObject2).d.getTag())) {
          ((aple)((apkk)paramXMediaEditor.getAdapter()).a.a(1)).a((aple.a)localObject2, this, 0);
        }
      }
      return ((Stream)localObject1).map(new UIThreadOffFunction(null));
    }
  }
  
  public boolean aBi()
  {
    return !TextUtils.isEmpty(this.mImageUrl);
  }
  
  public boolean aBj()
  {
    return TextUtils.isEmpty(this.mImageUrl);
  }
  
  public JSONObject af()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "img");
      localJSONObject.put("url", this.mImageUrl);
      localJSONObject.put("width", this.mWidth);
      localJSONObject.put("height", this.mHeight);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ImageInfo", 2, "ImageInfo getContent exception.");
    }
    return localJSONObject;
  }
  
  public void bN(JSONObject paramJSONObject)
    throws JSONException
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageInfo", 2, new Object[] { "ImageInfo createFrom json: ", paramJSONObject });
    }
    this.mData = paramJSONObject;
    SZ(paramJSONObject.optString("url"));
    this.mWidth = paramJSONObject.optInt("width");
    this.mHeight = paramJSONObject.optInt("height");
  }
  
  public void eay()
  {
    long l = System.currentTimeMillis();
    if (ahbj.fileExistsAndNotEmpty(this.mImagePath))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(this.mImagePath, localOptions);
      this.mWidth = localOptions.outWidth;
      this.mHeight = localOptions.outHeight;
      int i = JpegExifReader.readOrientation(this.mImagePath);
      if ((i == 6) || (i == 5) || (i == 8) || (i == 7))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageInfo", 2, new Object[] { "calculateLocalImageSize need orientation. before width=", Integer.valueOf(this.mWidth), ", height=", Integer.valueOf(this.mHeight), ", path=", this.mImagePath });
        }
        i = this.mWidth;
        this.mWidth = this.mHeight;
        this.mHeight = i;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageInfo", 2, new Object[] { "calculateLocalImageSize result. width=", Integer.valueOf(this.mWidth), ", height=", Integer.valueOf(this.mHeight), ", path=", this.mImagePath, ", cost=", Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
  
  public int getSize()
  {
    return 0;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public static class a
    extends JobSegment<apks, apks>
  {
    private boolean cRe;
    private int mMaxWidth;
    
    public a(int paramInt)
    {
      this.mMaxWidth = paramInt;
    }
    
    protected void a(JobContext paramJobContext, apks paramapks)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment start. info status=", Integer.valueOf(paramapks.mUploadStatus) });
      }
      apks.Br();
      try
      {
        String str = TroopHWJsPlugin.a(-1, paramapks.mImagePath, this.mMaxWidth, null);
        if (ahbj.fileExistsAndNotEmpty(str)) {}
        for (paramapks.cpQ = str;; paramapks.cpQ = paramapks.mImagePath)
        {
          QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment. in path=", paramapks.mImagePath, ", out path=", paramapks.cpQ });
          if (isCanceled()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CompressImageSegment", 2, new Object[] { "CompressImageSegment notifyResult. info status=", Integer.valueOf(paramapks.mUploadStatus) });
          }
          notifyResult(paramapks);
          return;
          if (QLog.isColorLevel()) {
            QLog.e("CompressImageSegment", 2, "CompressImageSegment failed.");
          }
        }
        return;
      }
      catch (Exception paramJobContext)
      {
        QLog.e("CompressImageSegment", 1, "CompressImageSegment Exception: ", paramJobContext);
        notifyError(new Error("101"));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("CompressImageSegment", 1, "CompressImageSegment error. OutOfMemoryError");
        URLDrawable.clearMemoryCache();
        System.gc();
        if (!this.cRe)
        {
          this.cRe = true;
          a(paramJobContext, paramapks);
          return;
        }
        notifyError(new Error("-1"));
      }
    }
    
    public void onCancel()
    {
      notifyError(new Error("c_1000"));
    }
  }
  
  public static class b
    extends JobSegment<apks, apks>
  {
    private apks jdField_a_of_type_Apks;
    private awjs.c jdField_a_of_type_Awjs$c;
    private WeakReference<XMediaEditor> ie;
    private int mMediaType;
    private String mTroopUin;
    
    public b(int paramInt, XMediaEditor paramXMediaEditor, String paramString)
    {
      this.mMediaType = paramInt;
      this.ie = new WeakReference(paramXMediaEditor);
      this.mTroopUin = paramString;
    }
    
    protected void a(JobContext paramJobContext, apks paramapks)
    {
      if (isCanceled()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start. mediaType=", Integer.valueOf(this.mMediaType), ", info status=", Integer.valueOf(paramapks.mUploadStatus) });
      }
      this.jdField_a_of_type_Apks = paramapks;
      switch (this.mMediaType)
      {
      }
      for (paramJobContext = paramapks.cpQ;; paramJobContext = ((apkv)paramapks).cpS)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start - getFilePath: ", paramJobContext });
        }
        if (TextUtils.isEmpty(paramJobContext)) {
          break;
        }
        this.jdField_a_of_type_Awjs$c = paramapks.a(paramJobContext, this.mTroopUin);
        this.jdField_a_of_type_Awjs$c.a(new apks.b.a());
        this.jdField_a_of_type_Awjs$c.dIP();
        return;
      }
      notifyError(new Error("-2"));
    }
    
    public void onCancel()
    {
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, new Object[] { "UploadMediaSegment onCancel. mediaType=", Integer.valueOf(this.mMediaType) });
      }
      if (this.jdField_a_of_type_Awjs$c != null) {
        this.jdField_a_of_type_Awjs$c.cancel();
      }
      Error localError;
      switch (this.mMediaType)
      {
      default: 
        localError = new Error("c_1001");
      }
      for (;;)
      {
        notifyError(localError);
        return;
        localError = new Error("c_2002");
        continue;
        localError = new Error("c_2003");
      }
    }
    
    public class a
      implements awjs.b
    {
      private long arG;
      private float mRatio = 1.0F;
      private int mStartProgress;
      
      public a()
      {
        switch (apks.b.a(apks.b.this))
        {
        default: 
          this.mStartProgress = 0;
          this.mRatio = 1.0F;
          return;
        case 1: 
          this.mStartProgress = 10;
          this.mRatio = 0.85F;
          return;
        }
        this.mStartProgress = 95;
        this.mRatio = 0.05F;
      }
      
      public void onComplete(String paramString)
      {
        if (apks.b.this.isCanceled())
        {
          apks.b.this.onCancel();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(apks.b.a(apks.b.this)), ", info hash=", Integer.valueOf(apks.this.hashCode()), ", info status=", Integer.valueOf(apks.this.mUploadStatus) });
        }
        switch (apks.b.a(apks.b.this))
        {
        }
        while (!apks.b.this.isCanceled())
        {
          apks.b.a(apks.b.this, apks.this);
          return;
          apkv localapkv = (apkv)apks.this;
          localapkv.mVideoUrl = paramString;
          ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localapkv));
          continue;
          apks.this.mImageUrl = paramString;
        }
        apks.b.this.onCancel();
      }
      
      public void onError(int paramInt)
      {
        if (QLog.isColorLevel()) {
          QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(apks.this.getType()), ", mediaType=", Integer.valueOf(apks.b.a(apks.b.this)) });
        }
        if (apks.b.a(apks.b.this) == 2)
        {
          apks.b.b(apks.b.this, apks.this);
          return;
        }
        apks.b.a(apks.b.this, new Error("-3"));
      }
      
      public void onProgress(int paramInt)
      {
        if (apks.b.this.isCanceled())
        {
          if (QLog.isColorLevel()) {
            QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
          }
          apks.b.this.onCancel();
        }
        long l;
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(apks.b.a(apks.b.this)), ", info hash=", Integer.valueOf(apks.this.hashCode()), ", info status=", Integer.valueOf(apks.this.mUploadStatus), ", progress=", Integer.valueOf(paramInt) });
          }
          l = System.currentTimeMillis();
          paramInt = this.mStartProgress + (int)(this.mRatio * paramInt);
        } while ((paramInt >= 100) || (l - this.arG <= 500L));
        this.arG = l;
        ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apks
 * JD-Core Version:    0.7.0.1
 */