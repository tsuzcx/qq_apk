import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.mobileqq.troop.widget.AddedRobotView.a.a;
import com.tencent.qphone.base.util.QLog;

public class apuq
  implements aqdf.a
{
  public apuq(AddedRobotView paramAddedRobotView) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    QLog.i("AddedRobotView", 1, "onDecodeTaskCompleted uin: " + paramString);
    if (AddedRobotView.a(this.b) == null) {}
    for (;;)
    {
      return;
      if (!AddedRobotView.a(this.b).isPausing())
      {
        paramInt2 = AddedRobotView.a(this.b).getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          Object localObject = AddedRobotView.a(this.b).getChildViewHolder(AddedRobotView.a(this.b).getChildAt(paramInt1));
          if ((localObject instanceof AddedRobotView.a.a))
          {
            localObject = (AddedRobotView.a.a)localObject;
            if ((!TextUtils.isEmpty(((AddedRobotView.a.a)localObject).uin)) && (((AddedRobotView.a.a)localObject).uin.equals(paramString))) {
              ((AddedRobotView.a.a)localObject).E.setImageBitmap(paramBitmap);
            }
          }
          else
          {
            QLog.i("AddedRobotView", 2, "onDecodeTaskCompleted viewHolder correct uin not found ! ");
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apuq
 * JD-Core Version:    0.7.0.1
 */