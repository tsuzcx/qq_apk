import com.tencent.cloudfile.CloudDir;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class atio
  extends atin
{
  public List<Object> GW = new ArrayList();
  public int dirType = 0;
  private int epM = -1;
  
  public atio(int paramInt, atin paramatin)
  {
    super(paramatin.name);
    this.a = paramatin.a;
    this.dirType = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("FileGridData", 2, "showName:" + this.a.showName + " getTotalCount:" + getTotalCount());
    }
  }
  
  public atio(int paramInt, String paramString)
  {
    super(paramString);
    this.dirType = paramInt;
  }
  
  public void a(atin paramatin)
  {
    this.name = paramatin.name;
    this.a = paramatin.a;
    if (QLog.isColorLevel()) {
      QLog.d("FileGridData", 2, "showName:" + this.a.showName + " getTotalCount:" + getTotalCount());
    }
  }
  
  public void aau(int paramInt)
  {
    this.epM = paramInt;
  }
  
  public int ar(QQAppInterface paramQQAppInterface)
  {
    if (this.dirType == 0)
    {
      aull localaull = (aull)paramQQAppInterface.getManager(372);
      int i = ((atgc)paramQQAppInterface.getManager(373)).On();
      return localaull.OI() + i;
    }
    if (this.dirType == 1) {
      return ((aull)paramQQAppInterface.getManager(372)).OI();
    }
    if ((this.dirType == 4) || (this.dirType == 5) || (this.dirType == 7)) {
      return 0;
    }
    if (this.epM > 0) {
      return this.epM;
    }
    return getTotalCount();
  }
  
  public void mx(List paramList)
  {
    this.GW.clear();
    if (paramList != null) {
      this.GW.addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atio
 * JD-Core Version:    0.7.0.1
 */