import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;
import java.util.UUID;

public class aule
  extends aukz
{
  private smq.m a;
  
  public aule(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
    this.jdField_a_of_type_Smq$m = new aulf(this);
  }
  
  public void ei(QQAppInterface paramQQAppInterface)
  {
    int i = 1;
    if ((this.c != null) && (paramQQAppInterface != null))
    {
      if ((!this.c.cKX) || (this.c.peerType != 1) || (TextUtils.isEmpty(this.c.cjE)) || (this.c.dNP == 0) || (TextUtils.isEmpty(this.c.peerUin))) {
        break label209;
      }
      Object localObject = new apbr();
      ((apbr)localObject).Id = UUID.nameUUIDFromBytes(this.c.cjE.getBytes());
      ((apbr)localObject).mFileId = this.c.cjE;
      ((apbr)localObject).str_file_name = this.c.fileName;
      ((apbr)localObject).dTg = this.c.dNP;
      localObject = new TroopFileTransferManager.Item((apbr)localObject);
      ((TroopFileTransferManager.Item)localObject).FileName = this.c.fileName;
      smq.a(paramQQAppInterface, Long.valueOf(this.c.peerUin).longValue(), (TroopFileTransferManager.Item)localObject, 0, false, false, this.jdField_a_of_type_Smq$m);
    }
    for (;;)
    {
      if (i == 0)
      {
        this.c.cKX = false;
        this.jdField_a_of_type_Aukx.h(this.c);
      }
      this.jdField_a_of_type_Aukx.d(this.c);
      return;
      label209:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aule
 * JD-Core Version:    0.7.0.1
 */