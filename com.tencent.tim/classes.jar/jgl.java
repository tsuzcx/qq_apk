import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.a;
import com.tencent.av.business.manager.EffectConfigBase.b;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.ui.funchat.magicface.MagicfaceViewForAV;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jgl
  implements EffectConfigBase.a<FaceItem>
{
  boolean Zg;
  FaceItem a;
  protected MagicfaceViewForAV a;
  WeakReference<ViewGroup> bI;
  protected RelativeLayout eu;
  private VideoAppInterface mApp;
  private ijv mFaceManager;
  
  public jgl(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  private void a(long paramLong, ViewGroup paramViewGroup, boolean paramBoolean, FaceItem paramFaceItem, int paramInt)
  {
    if (paramFaceItem.isSameType("face")) {
      e(paramViewGroup);
    }
    for (;;)
    {
      this.mFaceManager.a(paramLong, paramFaceItem, paramFaceItem.getId(), paramBoolean, this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV);
      return;
      if ((paramFaceItem.isSameType("pendant")) || (paramFaceItem.isSameType("creativecop"))) {
        f(paramViewGroup);
      } else if (paramFaceItem.isSameType("voicesticker")) {
        e(paramViewGroup);
      }
    }
  }
  
  private void awe()
  {
    if (this.mFaceManager == null) {
      this.mFaceManager = ((ijv)this.mApp.a(3));
    }
  }
  
  private void e(ViewGroup paramViewGroup)
  {
    Object localObject = new StringBuilder().append("realyShowView : ");
    if (this.eu == null) {}
    for (boolean bool = true;; bool = false)
    {
      igd.aL("MagicfaceViewProxy", bool);
      if (this.eu == null)
      {
        localObject = View.inflate(BaseApplicationImpl.getContext(), 2131559928, null);
        this.eu = ((RelativeLayout)((View)localObject).findViewById(2131371054));
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV = ((MagicfaceViewForAV)((View)localObject).findViewById(2131371052));
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV.setZOrderMediaOverlay(true);
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV.getHolder().setFormat(-2);
        localObject = paramViewGroup.findViewById(2131374269);
        int i = -1;
        if (localObject != null) {
          i = paramViewGroup.indexOfChild((View)localObject);
        }
        paramViewGroup.addView(this.eu, i);
      }
      this.eu.setVisibility(0);
      return;
    }
  }
  
  public void a(long paramLong, ViewGroup paramViewGroup, iya.e parame)
  {
    boolean bool2 = false;
    Object localObject = new StringBuilder().append("showView, requestPlayMagicFace[").append(parame).append("], mRootView[");
    if (paramViewGroup != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.w("MagicfaceViewProxy", 1, bool1 + "], mItem[" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem + "], seq[" + paramLong + "]");
      if (paramViewGroup != null) {
        break;
      }
      return;
    }
    awe();
    this.mFaceManager.a(paramLong, this);
    localObject = (FaceItem)this.mFaceManager.a(parame.mId);
    bool1 = bool2;
    if (localObject != null)
    {
      ikt localikt = (ikt)this.mApp.a(5);
      bool1 = localikt.d(3, "normal");
      bool2 = localikt.d(3, "interact");
      if ((bool1) && ((bool2) || (!((FaceItem)localObject).isInteract()))) {
        break label253;
      }
      bool1 = true;
      if (bool1) {
        break label300;
      }
      if (!((FaceItem)localObject).isUsable()) {
        break label259;
      }
      a(paramLong, paramViewGroup, parame.Wb, (FaceItem)localObject, parame.mFrom);
    }
    label259:
    label300:
    for (;;)
    {
      QLog.w("MagicfaceViewProxy", 1, "showView, dimmed[" + bool1 + "], item[" + localObject + "]");
      return;
      label253:
      bool1 = false;
      break;
      this.bI = new WeakReference(paramViewGroup);
      this.Zg = parame.Wb;
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem = ((FaceItem)localObject);
      this.mFaceManager.a(parame.bK(), (EffectConfigBase.b)localObject);
    }
  }
  
  public void a(ViewGroup paramViewGroup, String paramString, boolean paramBoolean)
  {
    if (paramViewGroup == null) {}
    while (!this.mApp.ch(3)) {
      return;
    }
    awe();
    this.mFaceManager.b(-1048L, this);
    this.mFaceManager.a(0, paramString, paramBoolean);
    f(paramViewGroup);
  }
  
  public void f(ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("realyHideView : ");
    if (this.eu == null) {}
    for (boolean bool = true;; bool = false)
    {
      igd.aJ("MagicfaceViewProxy", bool);
      if (this.eu != null)
      {
        paramViewGroup.removeView(this.eu);
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewForAV = null;
        this.eu = null;
      }
      return;
    }
  }
  
  public void onDownloadFinish(long paramLong, FaceItem paramFaceItem, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.bI != null) && (paramFaceItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem.getId().equalsIgnoreCase(paramFaceItem.getId())))
    {
      ViewGroup localViewGroup = (ViewGroup)this.bI.get();
      if (localViewGroup != null)
      {
        QLog.w("MagicfaceViewProxy", 1, "onDownloadFinish, prepareShow, seq[" + paramLong + "], FaceItem[" + paramFaceItem + "]");
        a(paramLong, localViewGroup, this.Zg, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceFaceItem, 6);
      }
    }
  }
  
  public void onItemSelectedChanged(long paramLong, FaceItem paramFaceItem) {}
  
  public void onProgressUpdate(FaceItem paramFaceItem, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jgl
 * JD-Core Version:    0.7.0.1
 */