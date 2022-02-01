import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudOnlineFileExt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.teamwork.PadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class auib
  extends augv
  implements auhk.f
{
  atgd a;
  protected auhk.g a;
  private atiu jdField_c_of_type_Atiu;
  aulm jdField_c_of_type_Aulm = new auid(this);
  private byte[] cA;
  private boolean diR;
  private boolean isComplete;
  private List<atiu> list = new ArrayList();
  private Map<String, FileManagerEntity> pD = new ConcurrentHashMap();
  private String version;
  
  public auib(QQAppInterface paramQQAppInterface, auhk.g paramg, byte[] paramArrayOfByte)
  {
    super(paramQQAppInterface, paramg);
    this.jdField_a_of_type_Atgd = new auic(this);
    this.cA = paramArrayOfByte;
    this.jdField_a_of_type_Auhk$g = paramg;
  }
  
  private void euW()
  {
    ateh localateh;
    if ((!isComplete()) && (this.list.size() < 10))
    {
      localateh = (ateh)this.app.getBusinessHandler(180);
      if (this.list.size() > 0) {
        localateh.a(this.cA, 2, this.jdField_c_of_type_Atiu);
      }
    }
    else
    {
      return;
    }
    localateh.a(this.cA, 1, this.jdField_c_of_type_Atiu);
  }
  
  private void hu(List<atiu> paramList)
  {
    Collections.sort(paramList, new auie(this));
  }
  
  private boolean y(byte[] paramArrayOfByte)
  {
    return Arrays.equals(this.cA, paramArrayOfByte);
  }
  
  private boolean z(byte[] paramArrayOfByte)
  {
    return Arrays.equals(((atgc)this.app.getManager(373)).aE(), paramArrayOfByte);
  }
  
  public void VP(boolean paramBoolean)
  {
    this.diR = paramBoolean;
  }
  
  public Object W()
  {
    return this.jdField_c_of_type_Atiu;
  }
  
  public void eva()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.list.size())
    {
      if ((this.list.get(i) instanceof FileManagerEntity))
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.list.get(i);
        String str1 = localFileManagerEntity.getPadUrl();
        if (str1 != null)
        {
          String str2 = localFileManagerEntity.cloudFile.onlineFileExt.localId;
          int j = localFileManagerEntity.cloudFile.onlineFileExt.domainId;
          str2 = j + "$" + str2;
          localArrayList.add(str1);
          this.pD.put(str2, localFileManagerEntity);
        }
      }
      i += 1;
    }
    if (!localArrayList.isEmpty()) {
      ((aulh)this.app.getBusinessHandler(178)).nY(localArrayList);
    }
  }
  
  public void gO(String paramString, int paramInt)
  {
    aull localaull = (aull)this.app.getManager(372);
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < this.list.size(); bool1 = bool2)
    {
      bool2 = bool1;
      if ((this.list.get(i) instanceof FileManagerEntity))
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.list.get(i);
        Object localObject = localFileManagerEntity.getPadUrl();
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (((String)localObject).equals(paramString))
          {
            bool2 = bool1;
            if (localaull != null)
            {
              localObject = localaull.a((String)localObject, paramInt);
              bool2 = bool1;
              if (localObject != null)
              {
                localFileManagerEntity.cloudFile.onlineFileExt.permissionType = athu.kZ(((PadInfo)localObject).policy);
                bool2 = true;
                atgi.a().updateOnlineInfo(localFileManagerEntity.cloudFile.onlineFileExt);
              }
            }
          }
        }
      }
      i += 1;
    }
    if ((this.jdField_a_of_type_Auhk$g != null) && (this.jdField_a_of_type_Auhk$g.Pp())) {
      this.jdField_a_of_type_Auhk$g.f(bool1, 3, isComplete());
    }
  }
  
  public List<atiu> hk()
  {
    return this.list;
  }
  
  public boolean isComplete()
  {
    return this.isComplete;
  }
  
  protected void onCreate()
  {
    this.app.addObserver(this.jdField_a_of_type_Atgd);
    this.app.addObserver(this.jdField_c_of_type_Aulm);
  }
  
  protected void onDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Atgd);
    this.app.removeObserver(this.jdField_c_of_type_Aulm);
    this.list.clear();
    this.isComplete = false;
    this.version = null;
    this.jdField_c_of_type_Atiu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auib
 * JD-Core Version:    0.7.0.1
 */