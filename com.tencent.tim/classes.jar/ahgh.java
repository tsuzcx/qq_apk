import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahgh
  extends ahgq
{
  public ahgh(Intent paramIntent)
  {
    super(paramIntent);
    this.cgP = true;
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1003) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && ((localRecentUser.getType() != 1) || (!kj(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 8001) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.cgP))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void b(Drawable paramDrawable, boolean paramBoolean)
  {
    URLDrawable localURLDrawable;
    if (paramBoolean)
    {
      localURLDrawable = (URLDrawable)paramDrawable;
      if (this.bKu == null) {
        break label33;
      }
      aoop.a(localURLDrawable, this.app.getCurrentAccountUin(), false);
    }
    while (paramDrawable == null)
    {
      return;
      label33:
      aoop.a(localURLDrawable, this.app.getCurrentAccountUin(), true);
    }
    paramDrawable.setBounds(0, 0, cZR, cZR);
  }
  
  public void dnr()
  {
    super.dnr();
    if (this.mIntent.getBooleanExtra("k_dataline", true))
    {
      this.cs.add(W);
      this.cs.add(ab);
    }
  }
  
  protected void dns()
  {
    this.e.setMessage(null);
    this.e.setMessageCount(this.bKu);
  }
  
  protected void dt(Intent paramIntent)
  {
    ArrayList localArrayList3 = null;
    ArrayList localArrayList4 = this.bf.getParcelableArrayList("fileinfo_array");
    ArrayList localArrayList1 = localArrayList3;
    if (localArrayList4 != null) {}
    try
    {
      localArrayList1 = (ArrayList)localArrayList4;
      localArrayList3 = (ArrayList)this.bf.get("android.intent.extra.STREAM");
      localArrayList3 = (ArrayList)this.bf.get("PhotoConst.PHOTO_PATHS");
      paramIntent.putExtra("dataline_forward_type", 101);
      paramIntent.putExtra("sendMultiple", true);
      if (localArrayList1 == null) {
        paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList3);
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        ArrayList localArrayList2 = localArrayList3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahgh
 * JD-Core Version:    0.7.0.1
 */