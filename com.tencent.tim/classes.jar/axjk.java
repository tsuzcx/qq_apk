import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.weseevideo.common.utils.GsonUtils;
import com.tencent.weseevideo.model.MediaModel;
import dov.com.qq.im.ae.camera.core.AEEditorOrderBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AEEditorOrderBroadcastReceiver.a;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class axjk
  implements axjo, AEEditorOrderBroadcastReceiver.a
{
  private Queue<axjn> T = new ArrayDeque();
  private AEEditorOrderBroadcastReceiver a = new AEEditorOrderBroadcastReceiver(this);
  private final long aCf = 1000L;
  private final long aCg = 5000L;
  private boolean baj;
  private Map<String, axjn> qK = new ConcurrentHashMap();
  
  private axjk()
  {
    this.a.gE(BaseApplicationImpl.getContext());
  }
  
  public static axjk a()
  {
    return axjk.a.b;
  }
  
  @Nullable
  private MediaModel a(@NonNull String paramString)
  {
    paramString = axis.a().t(paramString, "", 0);
    if (!TextUtils.isEmpty(paramString)) {
      return (MediaModel)GsonUtils.json2Obj(paramString, MediaModel.class);
    }
    return null;
  }
  
  private void a(@NonNull axjn paramaxjn)
  {
    if (this.T.size() == 0)
    {
      axiy.i("AEEditorProcessManager", "[tryStartTask] size 0");
      this.T.add(paramaxjn);
      paramaxjn.aCi = System.currentTimeMillis();
      paramaxjn.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
      return;
    }
    axjn localaxjn = (axjn)this.T.peek();
    if (Math.abs(System.currentTimeMillis() - localaxjn.aCi) > 5000L)
    {
      axiy.i("AEEditorProcessManager", "[tryStartTask] Dog Dead next Mission");
      this.T.remove(localaxjn);
      this.T.add(paramaxjn);
      eLI();
      return;
    }
    axiy.i("AEEditorProcessManager", "[tryStartTask]Dog alive");
    this.T.add(paramaxjn);
  }
  
  private void ace(@NonNull String paramString)
  {
    axiy.i("AEEditorProcessManager", "[cancel mission]");
    paramString = (axjn)this.qK.get(paramString);
    if ((paramString != null) && (!paramString.status.equals("AEEDITOR_GENERATE_STATUS_READY")))
    {
      paramString = paramString.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.a();
      if (paramString != null) {
        paramString.cancel();
      }
    }
  }
  
  private void ada(@NonNull String paramString)
  {
    axiy.i("AEEditorProcessManager", "[save mission]");
    axjn localaxjn = (axjn)this.qK.get(paramString);
    if (localaxjn != null)
    {
      axis.a().ai(paramString, localaxjn.jdField_a_of_type_ComTencentWeseevideoModelMediaModel.toString(), 0);
      axis.a().ai(paramString + "sourcePath", localaxjn.sourcePath, 0);
      axis.a().ai(paramString + "outputPath", localaxjn.outputPath, 0);
      axis.a().ai(paramString + "thumbPath", localaxjn.thumbPath, 0);
      axis.a().ai(paramString + "status", localaxjn.status, 0);
    }
  }
  
  private void adb(@NonNull String paramString)
  {
    axiy.i("AEEditorProcessManager", "[remove mission]");
    axis.a().hh(paramString, 0);
    axis.a().hh(paramString + "sourcePath", 0);
    axis.a().hh(paramString + "outputPath", 0);
    axis.a().hh(paramString + "thumbPath", 0);
    axis.a().hh(paramString + "status", 0);
  }
  
  private void b(@NonNull axjn paramaxjn)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramaxjn.status);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("generate_path", paramaxjn.path);
    localIntent.putExtra("generate_mission", paramaxjn.missionID);
    localIntent.putExtra("generate_progress", paramaxjn.progress);
    localIntent.putExtra("generate_thumb_ptah", paramaxjn.thumbPath);
    localIntent.putExtra("generate_errorcode", paramaxjn.errorCode);
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private void eLI()
  {
    if (this.T.size() == 0) {
      axiy.i("AEEditorProcessManager", "[tryStartNext] No mission");
    }
    axjn localaxjn;
    do
    {
      return;
      localaxjn = (axjn)this.T.peek();
    } while (localaxjn == null);
    axiy.i("AEEditorProcessManager", "[tryStartNext] next mission");
    localaxjn.aCi = System.currentTimeMillis();
    localaxjn.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable.run();
  }
  
  public void Yr(boolean paramBoolean)
  {
    this.baj = paramBoolean;
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull MediaModel paramMediaModel)
  {
    if (this.qK.get(paramString1) == null)
    {
      paramString4 = new axjn(paramString1, paramString2, paramString3, paramString4, paramMediaModel);
      this.qK.put(paramString1, paramString4);
      ada(paramString1);
    }
    for (;;)
    {
      paramString4.jdField_a_of_type_DovComQqImAeeditorModuleExportAEEditorGenerateRunnable = new AEEditorGenerateRunnable(paramString1, paramString2, paramString3, paramMediaModel, this);
      a(paramString4);
      do
      {
        return;
        paramString4 = (axjn)this.qK.get(paramString1);
        if (paramString4.status.equals("AEEDITOR_GENERATE_STATUS_ERROR")) {
          break;
        }
      } while (!paramString4.status.equals("AEEDITOR_GENERATE_STATUS_READY"));
      b(paramString4);
      return;
    }
  }
  
  public boolean aOL()
  {
    if (this.baj) {
      return true;
    }
    Iterator localIterator = this.qK.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((axjn)localEntry.getValue()).status.equals("AEEDITOR_GENERATE_STATUS_DOWNLOADING")) || (((axjn)localEntry.getValue()).status.equals("AEEDITOR_GENERATE_STATUS_WAIT"))) {
        return true;
      }
    }
    return false;
  }
  
  public void acZ(@Nullable String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      axiy.e("AEEditorProcessManager", "[requestGenerateVideo] mission is none");
      return;
    }
    axjn localaxjn = (axjn)this.qK.get(paramString);
    if (localaxjn == null)
    {
      String str1 = axis.a().t(paramString + "sourcePath", "", 0);
      String str2 = axis.a().t(paramString + "outputPath", "", 0);
      String str3 = axis.a().t(paramString + "thumbPath", "", 0);
      Object localObject = axis.a().t(paramString + "status", "", 0);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString = new axjn(paramString, str1, str2, str3, null);
        paramString.status = "AEEDITOR_GENERATE_STATUS_ERROR";
        paramString.errorCode = -2;
        axiy.e("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(paramString);
        return;
      }
      if (((String)localObject).equals("AEEDITOR_GENERATE_STATUS_READY"))
      {
        axiy.i("AEEditorProcessManager", "[requestGenerateVideo] mission is Ready");
        paramString = new axjn(paramString, str1, str2, str3, null);
        paramString.status = "AEEDITOR_GENERATE_STATUS_READY";
        b(paramString);
        return;
      }
      localObject = a(paramString);
      axiy.i("AEEditorProcessManager", "[requestGenerateVideo] peak is dead");
      if (localObject == null)
      {
        localaxjn.status = "AEEDITOR_GENERATE_STATUS_ERROR";
        localaxjn.errorCode = -2;
        axiy.e("AEEditorProcessManager", "[requestGenerateVideo] GENERATE_ERROR_NODATA");
        b(localaxjn);
        return;
      }
      a(paramString, str1, str2, str3, (MediaModel)localObject);
      return;
    }
    axiy.i("AEEditorProcessManager", "[requestGenerateVideo] peak is alive");
    a(paramString, localaxjn.sourcePath, localaxjn.outputPath, localaxjn.thumbPath, localaxjn.jdField_a_of_type_ComTencentWeseevideoModelMediaModel);
  }
  
  public void ach(String paramString)
  {
    ace(paramString);
  }
  
  public void aci(String paramString)
  {
    adb(paramString);
  }
  
  public void adc(@NonNull String paramString)
  {
    paramString = (axjn)this.qK.get(paramString);
    if (paramString != null)
    {
      paramString.aCi = System.currentTimeMillis();
      paramString.status = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    }
  }
  
  public void clean()
  {
    this.a.gF(BaseApplicationImpl.getContext());
    this.T.clear();
  }
  
  public void init()
  {
    if (!awtj.init()) {
      axiy.d("AEEditorProcessManager", "AEKitForQQ.init() fail");
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.getContext(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), new axjl(this));
      return;
      if (!FeatureManager.loadBasicFeatures()) {
        axiy.d("AEEditorProcessManager", "loadBasicFeatures.init() fail");
      }
      if (!FeatureManager.Features.PAG.init()) {
        axiy.d("AEEditorProcessManager", "PAG.init() fail");
      }
      if (!FeatureManager.Features.IMAGE_ALGO.init()) {
        axiy.d("AEEditorProcessManager", "IMAGE_ALGO.init() fail");
      }
    }
  }
  
  public void jP(@NonNull String paramString1, @NonNull String paramString2)
  {
    axjn localaxjn = (axjn)this.qK.get(paramString1);
    if (localaxjn != null)
    {
      localaxjn.status = "AEEDITOR_GENERATE_STATUS_READY";
      localaxjn.path = paramString2;
      localaxjn.progress = 1.0F;
      b(localaxjn);
      axis.a().ai(paramString1 + "status", localaxjn.status, 0);
      this.T.remove(localaxjn);
      eLI();
    }
  }
  
  public void onAETavSessionExportError(@NonNull String paramString, int paramInt)
  {
    paramString = (axjn)this.qK.get(paramString);
    if (paramString != null)
    {
      paramString.status = "AEEDITOR_GENERATE_STATUS_ERROR";
      paramString.progress = 0.0F;
      paramString.errorCode = paramInt;
      b(paramString);
      this.T.remove(paramString);
      eLI();
    }
  }
  
  public void onAETavSessionExporting(@NonNull String paramString, float paramFloat)
  {
    paramString = (axjn)this.qK.get(paramString);
    if (paramString != null)
    {
      paramString.aCi = System.currentTimeMillis();
      paramString.progress = paramFloat;
      long l = System.currentTimeMillis();
      if (Math.abs(l - paramString.aCh) > 1000L)
      {
        paramString.aCh = l;
        b(paramString);
      }
    }
  }
  
  static class a
  {
    static final axjk b = new axjk(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axjk
 * JD-Core Version:    0.7.0.1
 */