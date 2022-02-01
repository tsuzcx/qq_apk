import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.qphone.base.util.QLog;

class aqpz
  extends Client.b
{
  aqpz(aqpt paramaqpt) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle arg1)
  {
    if (???.getInt("srcType") != 5) {}
    int i;
    int j;
    label280:
    label464:
    label614:
    do
    {
      do
      {
        long l;
        do
        {
          for (;;)
          {
            return;
            String str1 = ???.getString("status");
            l = ???.getLong("id");
            i = ???.getInt("progress");
            boolean bool = ???.getBoolean("result");
            j = ???.getInt("resourceType");
            String str2 = ???.getString("colorType");
            if (QLog.isColorLevel()) {
              QLog.d("ColorRingPlayer", 2, "onPushMsg," + l + "," + j + "," + str1 + "," + i + "," + bool);
            }
            synchronized (this.this$0.jdField_a_of_type_Aqpt$a)
            {
              if (this.this$0.jdField_a_of_type_Aqpt$a.atA != l)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ColorRingPlayer", 2, "curId=" + this.this$0.jdField_a_of_type_Aqpt$a.atA + ", pushId=" + l);
                }
                return;
              }
            }
            if (!"onStart".equals(localObject1))
            {
              if (!"onDone".equals(localObject1)) {
                break label614;
              }
              if (!bool) {
                break label464;
              }
              if (j == 3)
              {
                if ("colorring".equals(str2))
                {
                  this.this$0.dy.setText(this.this$0.d.getResources().getString(2131719567));
                  this.this$0.Fi.setImageDrawable(this.this$0.d.getResources().getDrawable(2130847956));
                  this.this$0.Fi.setVisibility(0);
                  this.this$0.Fh.setVisibility(8);
                }
                synchronized (this.this$0.jdField_a_of_type_Aqpt$a)
                {
                  this.this$0.jdField_a_of_type_Aqpt$a.aNy = 3;
                  if (this.this$0.cVA)
                  {
                    this.this$0.aY(l, 0);
                    return;
                    if (!"comering".equals(str2)) {
                      break label280;
                    }
                    this.this$0.dy.setText(this.this$0.d.getResources().getString(2131719569));
                  }
                }
              }
            }
          }
          if (j == 2)
          {
            this.this$0.bQ(aqpr.a(l));
            return;
          }
        } while ((j != 1) || (aqpr.e(l) == null));
        this.this$0.fV.setImageBitmap(aqpr.e(l));
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ColorRingPlayer", 2, "onDone, failure," + l + "," + j);
        }
      } while (j != 3);
      this.this$0.dy.setText(this.this$0.d.getResources().getString(2131691752));
      this.this$0.Fi.setImageDrawable(this.this$0.d.getResources().getDrawable(2130847954));
      this.this$0.Fi.setVisibility(0);
      this.this$0.Fh.setVisibility(8);
      synchronized (this.this$0.jdField_a_of_type_Aqpt$a)
      {
        this.this$0.jdField_a_of_type_Aqpt$a.aNy = 0;
        return;
      }
    } while ((!"onProgress".equals(localObject3)) || (j != 3) || (this.this$0.jdField_a_of_type_Argt == null));
    this.this$0.jdField_a_of_type_Argt.setLevel(i * 100);
    this.this$0.jdField_a_of_type_Argt.invalidateSelf();
  }
  
  public void onResponse(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpz
 * JD-Core Version:    0.7.0.1
 */