import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aflz
  implements afon.a
{
  aflz(aflw paramaflw) {}
  
  public void jS(List<afom> paramList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshPanelData call back dataList = ");
      if (paramList != null) {
        break label60;
      }
    }
    label60:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.d("CameraEmotionAdapter", 2, localObject);
      if (paramList != null)
      {
        this.a.setData(paramList);
        this.a.notifyDataSetChanged();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aflz
 * JD-Core Version:    0.7.0.1
 */