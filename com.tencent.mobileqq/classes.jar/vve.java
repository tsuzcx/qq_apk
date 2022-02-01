import android.util.SparseArray;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListenerProxy;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListenerProxy;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListenerProxy;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone;
import dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone.AEEditorGenerateResultListener;
import dov.com.qq.im.ae.camera.core.AEEditorManagerForQzone.AEEditorUICallbackListener;

public class vve
{
  private static volatile vve jdField_a_of_type_Vve;
  private SparseArray<AEEditorManagerForQzone.AEEditorGenerateResultListener> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseArray<AEEditorManagerForQzone.AEEditorUICallbackListener> b = new SparseArray();
  private SparseArray<biyn> c = new SparseArray();
  
  public static vve a()
  {
    if (jdField_a_of_type_Vve == null) {}
    try
    {
      if (jdField_a_of_type_Vve == null) {
        jdField_a_of_type_Vve = new vve();
      }
      return jdField_a_of_type_Vve;
    }
    finally {}
  }
  
  public void a(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    QCircleAEEditorGenerateResultListenerProxy localQCircleAEEditorGenerateResultListenerProxy = new QCircleAEEditorGenerateResultListenerProxy(paramQCircleAEEditorGenerateResultListener);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(paramQCircleAEEditorGenerateResultListener.hashCode(), localQCircleAEEditorGenerateResultListenerProxy);
    AEEditorManagerForQzone.getInstance().addListener(localQCircleAEEditorGenerateResultListenerProxy);
  }
  
  public void a(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    QCircleAEEditorUICallbackListenerProxy localQCircleAEEditorUICallbackListenerProxy = new QCircleAEEditorUICallbackListenerProxy(paramQCircleAEEditorUICallbackListener);
    this.b.append(paramQCircleAEEditorUICallbackListener.hashCode(), localQCircleAEEditorUICallbackListenerProxy);
    AEEditorManagerForQzone.getInstance().addUICallbackListener(localQCircleAEEditorUICallbackListenerProxy);
  }
  
  public void a(QCircleWXShareListener paramQCircleWXShareListener)
  {
    QCircleWXShareListenerProxy localQCircleWXShareListenerProxy = new QCircleWXShareListenerProxy(paramQCircleWXShareListener);
    this.c.append(paramQCircleWXShareListener.hashCode(), localQCircleWXShareListenerProxy);
    WXShareHelper.a().a(localQCircleWXShareListenerProxy);
  }
  
  public void b(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    paramQCircleAEEditorGenerateResultListener = (AEEditorManagerForQzone.AEEditorGenerateResultListener)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramQCircleAEEditorGenerateResultListener.hashCode());
    if (paramQCircleAEEditorGenerateResultListener != null) {
      AEEditorManagerForQzone.getInstance().removeListener(paramQCircleAEEditorGenerateResultListener);
    }
  }
  
  public void b(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    paramQCircleAEEditorUICallbackListener = (AEEditorManagerForQzone.AEEditorUICallbackListener)this.b.get(paramQCircleAEEditorUICallbackListener.hashCode());
    if (paramQCircleAEEditorUICallbackListener != null) {
      AEEditorManagerForQzone.getInstance().removeCallbackListener(paramQCircleAEEditorUICallbackListener);
    }
  }
  
  public void b(QCircleWXShareListener paramQCircleWXShareListener)
  {
    paramQCircleWXShareListener = (biyn)this.c.get(paramQCircleWXShareListener.hashCode());
    if (paramQCircleWXShareListener != null) {
      WXShareHelper.a().b(paramQCircleWXShareListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vve
 * JD-Core Version:    0.7.0.1
 */