import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class aabp
  implements IRedPacket.OnGetSkinListener
{
  aabp(aabn paramaabn) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    aabl localaabl = aabl.a.a(aabn.a(this.b), paramRedPacketInfoBase.skinId);
    List localList;
    if (localaabl != null)
    {
      localList = aabn.a(this.b).getList();
      QLog.d("HbSkinLogic", 2, "redl iscache = " + aabl.buW + " info.iscache = " + paramRedPacketInfoBase.isCache);
      if ((aabl.buW == paramRedPacketInfoBase.isCache) && (!localList.contains(localaabl))) {
        break label98;
      }
      QLog.d("HbSkinLogic", 2, "no add in list...");
    }
    label98:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = aabn.access$800();
    }
    localaabl.a = paramRedPacketInfoBase;
    QLog.d("HbSkinLogic", 2, "redl add to list show!");
    localList.add(localaabl);
    aabl.hu(localList);
    aabn.a(this.b).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabp
 * JD-Core Version:    0.7.0.1
 */