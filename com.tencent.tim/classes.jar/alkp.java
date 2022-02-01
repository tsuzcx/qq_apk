import android.text.TextUtils;
import com.tencent.mobileqq.data.QCallRecent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class alkp
  implements alkq.a
{
  alkp(alkm paramalkm, alkq.a parama) {}
  
  public void lS(List<QCallRecent> paramList)
  {
    if (this.a != null)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QCallRecent localQCallRecent = (QCallRecent)paramList.next();
          if (localQCallRecent.type == 3000)
          {
            if ((TextUtils.isEmpty(localQCallRecent.pstnInfo)) || ((!TextUtils.isEmpty(localQCallRecent.pstnInfo)) && (localQCallRecent.pstnInfo.equals("[]")))) {
              localArrayList.add(localQCallRecent);
            }
          }
          else if (localQCallRecent.callType != 2) {
            localArrayList.add(localQCallRecent);
          }
        }
      }
      this.a.lS(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkp
 * JD-Core Version:    0.7.0.1
 */