import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qgw
  implements VideoCoverListBar.c
{
  private final boolean aDo;
  private int bmn = -1;
  private int bmo = -1;
  private List<String> mVidList = new ArrayList();
  
  public qgw(boolean paramBoolean)
  {
    this.aDo = paramBoolean;
  }
  
  public boolean Jw()
  {
    return this.bmo == 12;
  }
  
  public boolean Jx()
  {
    return this.bmo == 13;
  }
  
  public void a(int paramInt, ArrayList<qjq> paramArrayList, qgy.c paramc)
  {
    if (!this.aDo)
    {
      ram.d("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "close , set data invalidate");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      qjq localqjq = (qjq)paramArrayList.next();
      if ((!localqjq.JK()) && (!TextUtils.isEmpty(localqjq.vid))) {
        localArrayList.add(localqjq.vid);
      }
    }
    this.mVidList = localArrayList;
    this.bmn = paramInt;
    int i;
    if ((paramc instanceof qhc.a))
    {
      paramArrayList = (qhc.a)paramc;
      if (paramArrayList.g != null)
      {
        i = paramArrayList.g.nodeType;
        this.bmo = i;
        label129:
        i = this.mVidList.size();
        if (paramc != null) {
          break label186;
        }
      }
    }
    label186:
    for (paramArrayList = "";; paramArrayList = paramc.toString())
    {
      ram.a("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "setDataList , verticalPosition = %d , size = %d, groupId= %s, msgTabNodeType=%d", Integer.valueOf(paramInt), Integer.valueOf(i), paramArrayList, Integer.valueOf(this.bmo));
      return;
      i = -1;
      break;
      this.bmo = -1;
      break label129;
    }
  }
  
  public List<String> getData()
  {
    ram.b("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "getData , verticalPosition = %d , size = %d", Integer.valueOf(this.bmn), Integer.valueOf(this.mVidList.size()));
    return this.mVidList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgw
 * JD-Core Version:    0.7.0.1
 */