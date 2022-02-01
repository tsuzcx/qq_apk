import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xmn
  implements xmb
{
  private int jdField_a_of_type_Int = -1;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public xmn(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public List<String> a()
  {
    yuk.a("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "getData , verticalPosition = %d , size = %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, ArrayList<xqz> paramArrayList, xms paramxms)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      yuk.b("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "close , set data invalidate");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      xqz localxqz = (xqz)paramArrayList.next();
      if ((!localxqz.a()) && (!TextUtils.isEmpty(localxqz.a))) {
        localArrayList.add(localxqz.a);
      }
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_a_of_type_Int = paramInt;
    int i;
    if ((paramxms instanceof xng))
    {
      paramArrayList = (xng)paramxms;
      if (paramArrayList.a != null)
      {
        i = paramArrayList.a.jdField_a_of_type_Int;
        this.b = i;
        label129:
        i = this.jdField_a_of_type_JavaUtilList.size();
        if (paramxms != null) {
          break label186;
        }
      }
    }
    label186:
    for (paramArrayList = "";; paramArrayList = paramxms.toString())
    {
      yuk.a("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "setDataList , verticalPosition = %d , size = %d, groupId= %s, msgTabNodeType=%d", Integer.valueOf(paramInt), Integer.valueOf(i), paramArrayList, Integer.valueOf(this.b));
      return;
      i = -1;
      break;
      this.b = -1;
      break label129;
    }
  }
  
  public boolean a()
  {
    return this.b == 12;
  }
  
  public boolean b()
  {
    return this.b == 13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmn
 * JD-Core Version:    0.7.0.1
 */