import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class aflx
  implements EmoticonPanelLinearLayout.a
{
  aflx(aflw paramaflw) {}
  
  public boolean a(View paramView, afmi paramafmi)
  {
    if ((paramafmi == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramafmi.action))
    {
      Object localObject = (aflv)paramafmi;
      if ((((aflv)localObject).bDZ.equals("needUpload")) || (((aflv)localObject).bDZ.equals("needDel"))) {
        return true;
      }
      if (((aflv)localObject).bDZ.equals("failed"))
      {
        paramView = ((afhc)this.a.app.getManager(333)).ez();
        if (paramView != null)
        {
          paramView = paramView.iterator();
          while (paramView.hasNext())
          {
            paramafmi = (CameraEmotionData)paramView.next();
            if (paramafmi.emoId == ((aflv)localObject).emoId)
            {
              QLog.d("CameraEmotionAdapter", 1, new Object[] { "resend, emoId:", Integer.valueOf(paramafmi.emoId) });
              paramafmi.RomaingType = "needUpload";
              ((aflv)localObject).bDZ = "needUpload";
              ((accj)this.a.app.getBusinessHandler(160)).notifyUI(4, true, null);
              com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.bXW = false;
              ThreadManager.excute(new CameraEmoSingleSend(paramafmi, true), 64, null, false);
            }
          }
        }
        return true;
      }
      localObject = (URLImageView)paramView.findViewById(2131366331);
      paramView = (ImageView)paramView.findViewById(2131366332);
      if (!(((URLImageView)localObject).getBackground() instanceof URLDrawable)) {
        return false;
      }
      URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getBackground();
      if ((localURLDrawable.getStatus() == 3) || (localURLDrawable.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading failed, restart download " + paramafmi.toString());
        }
        ((URLImageView)localObject).setVisibility(8);
        paramView.setVisibility(0);
        localURLDrawable.restartDownload();
        if (!(paramView.getDrawable() instanceof Animatable)) {
          paramView.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839651));
        }
        ((Animatable)paramView.getDrawable()).start();
        return true;
      }
      if (localURLDrawable.getStatus() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraEmotionAdapter", 2, "now  cameraemo EmoticonInfo loading " + paramafmi.toString());
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflx
 * JD-Core Version:    0.7.0.1
 */