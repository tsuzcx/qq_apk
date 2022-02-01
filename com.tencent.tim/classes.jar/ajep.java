import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.io.File;
import java.util.List;

public class ajep
{
  private ajeq a;
  
  public ajep(String paramString)
  {
    this.a = new ajeq(paramString);
  }
  
  public static void Mu(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (Build.VERSION.SDK_INT >= 16)) {
      SQLiteDatabase.deleteDatabase(paramString);
    }
  }
  
  public int Gk()
  {
    return this.a.dz("msg");
  }
  
  public int Gl()
  {
    return this.a.dA("res");
  }
  
  public List<MsgBackupMsgEntity> a(long paramLong, int paramInt)
  {
    return this.a.a(paramLong, paramInt);
  }
  
  public void close()
  {
    if (this.a.isOpen()) {
      this.a.close();
    }
  }
  
  public List<MsgBackupExtraEntity> fC()
  {
    return this.a.fD();
  }
  
  public String getDbName()
  {
    return this.a.name;
  }
  
  public List<MsgBackupResEntity> h(int paramInt1, int paramInt2)
  {
    return this.a.b(paramInt1, paramInt2);
  }
  
  public List<MsgBackupResEntity> j(long paramLong1, long paramLong2)
  {
    return this.a.j(paramLong1, paramLong2);
  }
  
  public void lr(List<MsgBackupMsgEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.a.lr(paramList);
  }
  
  public void ls(List<MsgBackupResEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.a.ls(paramList);
  }
  
  public void lt(List<MsgBackupExtraEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.a.lu(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajep
 * JD-Core Version:    0.7.0.1
 */