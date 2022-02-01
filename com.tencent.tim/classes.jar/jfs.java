import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.g;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class jfs
{
  public static Bitmap a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = aqdj.a(paramQQAppInterface, paramString, (byte)2).aF();
    paramString = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      paramString = aqhu.G();
    }
    return paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Message paramMessage, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    View localView = paramView.findViewById(2131372076);
    TextView localTextView = (TextView)paramView.findViewById(2131372054);
    ImageView localImageView = (ImageView)paramView.findViewById(2131372053);
    int i;
    int j;
    boolean bool;
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      l = ((Long)paramMessage.obj).longValue();
      i = paramQQAppInterface.a().z(l);
      localObject = (LinearLayout)paramView.findViewById(2131372050);
      if (i == 2)
      {
        paramMessage = paramQQAppInterface.a().a(l);
        ((LinearLayout)localObject).setVisibility(0);
        localObject = new ImageView[3];
        localObject[0] = ((ImageView)paramView.findViewById(2131363177));
        localObject[1] = ((ImageView)paramView.findViewById(2131363179));
        localObject[2] = ((ImageView)paramView.findViewById(2131363181));
        if ((paramMessage == null) || (paramMessage.size() == 0))
        {
          j = localObject.length;
          i = 0;
        }
        while (i < j)
        {
          localObject[i].setVisibility(8);
          i += 1;
          continue;
          if (paramMessage.size() != 1) {
            break label426;
          }
          localObject[0].setVisibility(0);
          localObject[1].setVisibility(8);
          localObject[2].setVisibility(8);
          localObject[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.g)paramMessage.get(0)).id), paramQQAppInterface));
        }
      }
    }
    else
    {
      i = paramQQAppInterface.a().getSessionType();
      j = paramQQAppInterface.a().lh();
      l = paramQQAppInterface.a().bH();
      if (paramQQAppInterface.a().ll() != 2) {
        break label577;
      }
      bool = true;
      label292:
      if (QLog.isColorLevel()) {
        QLog.w("MultiVideoBarHelper", 1, "updateMultiVideoBar, randomStatus[" + j + "], sessionType[" + i + "], guildGroupId[" + l + "], getSmallScreenState[" + paramQQAppInterface.a().ll() + "]");
      }
      if (l <= 0L) {
        break label695;
      }
      j = paramQQAppInterface.a().lj();
      if (j >= 2) {
        break label583;
      }
      localTextView.setText(2131690203);
      ivv.a(localView, bool, paramBoolean);
    }
    label401:
    label925:
    for (;;)
    {
      anot.c(paramQQAppInterface, "dc00898", "", "", "0X8009EE1", "0X8009EE1", 1, 0, "", "", "", "");
      return;
      label426:
      if (paramMessage.size() == 2)
      {
        localObject[0].setVisibility(0);
        localObject[1].setVisibility(0);
        localObject[2].setVisibility(8);
        localObject[0].setImageBitmap(a(String.valueOf(((AVNotifyCenter.g)paramMessage.get(0)).id), paramQQAppInterface));
        localObject[1].setImageBitmap(a(String.valueOf(((AVNotifyCenter.g)paramMessage.get(1)).id), paramQQAppInterface));
        break;
      }
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].setVisibility(0);
        localObject[i].setImageBitmap(a(String.valueOf(((AVNotifyCenter.g)paramMessage.get(i)).id), paramQQAppInterface));
        i += 1;
      }
      break;
      ((LinearLayout)localObject).setVisibility(0);
      break;
      label577:
      bool = false;
      break label292;
      label583:
      paramView = paramQQAppInterface.a().gY();
      if ((paramView != null) && (paramView.equals("1")))
      {
        i = 1;
        label607:
        if (i == 0) {
          break label688;
        }
      }
      label688:
      for (i = 2131697883;; i = 2131697882)
      {
        paramMessage = paramQQAppInterface.getApp().getString(i);
        paramView = paramQQAppInterface.a().ha();
        paramMessage = String.format(paramMessage, new Object[] { Integer.valueOf(j) });
        localTextView.setText(paramMessage + " " + paramView);
        break;
        i = 0;
        break label607;
      }
      label695:
      if (j == 6)
      {
        localTextView.setText(paramQQAppInterface.getApp().getString(2131697884));
        ivv.a(localView, bool, paramBoolean);
      }
      else if (j >= 5)
      {
        paramView = paramQQAppInterface.getApp().getString(2131697882);
        paramView = paramView + " ";
        localTextView.setText(paramView + paramQQAppInterface.a().ha());
        ivv.a(localView, bool, paramBoolean);
      }
      else if ((j >= 1) && (j < 5))
      {
        localTextView.setText(paramQQAppInterface.getApp().getString(2131697571));
        ivv.a(localView, bool, paramBoolean);
      }
      else
      {
        if ((i != 3) && (i != 4)) {
          break label1316;
        }
        l = paramQQAppInterface.a().bG();
        i = paramQQAppInterface.a().z(l);
        j = paramQQAppInterface.a().lk();
        if (!paramQQAppInterface.a().uo()) {
          break label989;
        }
        localTextView.setText(2131690203);
        if ((i == 2) && (!paramQQAppInterface.a().cw(String.valueOf(l)))) {
          localImageView.setImageDrawable(null);
        }
        if (j != 1) {
          break label1257;
        }
        paramMessage = paramQQAppInterface.getApp().getString(2131694258);
        paramView = paramMessage;
        if (i == 2) {
          paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131721245), paramQQAppInterface.getApp().getString(2131721246));
        }
        jll.b(localView, paramView);
        label978:
        ivv.a(localView, bool, paramBoolean);
      }
    }
    label989:
    long l = paramQQAppInterface.a().bG();
    int k = paramQQAppInterface.a().lg();
    Object localObject = paramQQAppInterface.a().ha();
    if (j == 3000)
    {
      paramMessage = paramQQAppInterface.getApp().getString(2131690194);
      paramView = paramMessage;
      if (i == 2) {
        paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131721245), paramQQAppInterface.getApp().getString(2131721246));
      }
    }
    label1536:
    for (;;)
    {
      l = paramQQAppInterface.a().d(k, l);
      if ((localView != null) && (l == 0L))
      {
        ivv.a(localView, false, paramBoolean);
        return;
        if (j == 1)
        {
          paramView = paramQQAppInterface.getApp().getString(2131690187);
          if (i != 2) {
            break label1536;
          }
          paramView = paramView.replace(paramQQAppInterface.getApp().getString(2131721245), paramQQAppInterface.getApp().getString(2131721246));
          localImageView.setImageDrawable(null);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("MultiVideoBarHelper", 2, "updateMultiVideoBar-->wrong type of UinType.uintype=" + j);
        return;
      }
      if (localView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MultiVideoBarHelper", 2, "updateMultiVideoBar-->multiVideoBar is null");
        return;
      }
      paramView = String.format(paramView, new Object[] { Long.valueOf(l) });
      localTextView.setText(paramView + " " + (String)localObject);
      break label925;
      label1257:
      if (j != 3000) {
        break label978;
      }
      paramMessage = paramQQAppInterface.getApp().getString(2131694257);
      paramView = paramMessage;
      if (i == 2) {
        paramView = paramMessage.replace(paramQQAppInterface.getApp().getString(2131721245), paramQQAppInterface.getApp().getString(2131721246));
      }
      jll.b(localView, paramView);
      break label978;
      label1316:
      if (i == 1)
      {
        if (paramQQAppInterface.a().uo()) {
          localTextView.setText(2131698196);
        }
        for (;;)
        {
          jll.b(localView, paramQQAppInterface.getApp().getString(2131690636));
          ivv.a(localView, bool, paramBoolean);
          break;
          paramView = paramQQAppInterface.a().ha();
          paramMessage = paramQQAppInterface.getApp().getString(2131697562);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      if ((i == 2) && (!paramQQAppInterface.a().sB()))
      {
        if (paramQQAppInterface.a().uo()) {
          localTextView.setText(2131698196);
        }
        for (;;)
        {
          jll.b(localView, paramQQAppInterface.getApp().getString(2131690636));
          ivv.a(localView, bool, paramBoolean);
          break;
          paramView = paramQQAppInterface.a().ha();
          paramMessage = paramQQAppInterface.getApp().getString(2131698170);
          localTextView.setText(paramMessage + " " + paramView);
        }
      }
      ivv.a(localView, false, paramBoolean);
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfs
 * JD-Core Version:    0.7.0.1
 */