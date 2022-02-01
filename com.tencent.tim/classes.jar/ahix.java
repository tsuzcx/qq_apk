import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardPhotoOption;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.qphone.base.util.QLog;

public class ahix
{
  public static ahgq a(Intent paramIntent)
  {
    ahhq localahhq = null;
    int i = paramIntent.getIntExtra("forward_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardOptionBuilder", 2, "ForwardOptionBuilder forwardType=" + i);
    }
    if (i == 0) {
      localahhq = new ahhq(paramIntent);
    }
    do
    {
      return localahhq;
      if (i == 1) {
        return new ForwardPhotoOption(paramIntent);
      }
      if (i == -1) {
        return new ahmb(paramIntent);
      }
      if (i == -2) {
        return new ahid(paramIntent);
      }
      if (i == -3) {
        return new ahlx(paramIntent);
      }
      if (i == 17) {
        return new ahle(paramIntent);
      }
      if (i == 18) {
        return new ahhv(paramIntent);
      }
      if ((i == 20) || (i == 24)) {
        return new ahjv(paramIntent);
      }
      if (i == 42) {
        return new ahjy(paramIntent);
      }
      if (i == 11) {
        return new ahkr(paramIntent);
      }
      if (i == 15) {
        return new ahhc(paramIntent);
      }
      if (i == 2) {
        return new ahjt(paramIntent);
      }
      if (i == 12) {
        return new ahgh(paramIntent);
      }
      if (i == 1001) {
        return new ahjc(paramIntent);
      }
      if (i == -4) {
        return new ahhy(paramIntent);
      }
      if (i == 13) {
        return new ahmk(paramIntent);
      }
      if (i == 14) {
        return new ahhl(paramIntent);
      }
      if (i == 9) {
        return new ahie(paramIntent);
      }
      if (i == 16) {
        return new ahld(paramIntent);
      }
      if (i == 21) {
        return new ForwardShortVideoOption(paramIntent);
      }
      if (i == 22) {
        return new ahjq(paramIntent);
      }
      if (i == 10) {
        return new ahhf(paramIntent);
      }
      if (i == 23) {
        return new ahlr(paramIntent);
      }
      if (i == 25) {
        return new ahhw(paramIntent);
      }
      if (i == 27) {
        return new ahgo(paramIntent);
      }
      if (i == 38) {
        return new ahgm(paramIntent);
      }
      if (i == 35) {
        return new ahgk(paramIntent);
      }
      if (i == 33) {
        return new ahgl(paramIntent);
      }
      if (i == 26) {
        return new ahgi(paramIntent);
      }
      if (i == -5) {
        return new ahih(paramIntent);
      }
      if (i == 28) {
        return new ahjs(paramIntent);
      }
      if (i == 29) {
        return new ahjr(paramIntent);
      }
      if (i == 32) {
        return new ahmj(paramIntent);
      }
      if (i == 34) {
        return new ahgj(paramIntent);
      }
      if (i == 36) {
        return new ahmd(paramIntent);
      }
      if (i == 37) {
        return new ahhx(paramIntent);
      }
      if (i == 39) {
        return new ahju(paramIntent);
      }
      if (i == 41) {
        return new ahhu(paramIntent);
      }
      if (i == -6) {
        return new ahjw(paramIntent);
      }
    } while (i != 44);
    return new ahig(paramIntent);
  }
  
  public static ahgq a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramIntent.putExtra("emoInputType", 2);
    paramIntent = a(paramIntent);
    if (paramIntent != null)
    {
      paramIntent.b(paramQQAppInterface, paramActivity);
      paramIntent.anj();
    }
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahix
 * JD-Core Version:    0.7.0.1
 */