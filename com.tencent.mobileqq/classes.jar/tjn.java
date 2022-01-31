import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tjn
  implements tjb
{
  private int jdField_a_of_type_Int = -1;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public tjn(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public List<String> a()
  {
    urk.a("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "getData , verticalPosition = %d , size = %d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt, ArrayList<tnz> paramArrayList, tjs paramtjs)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      urk.b("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "close , set data invalidate");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      tnz localtnz = (tnz)paramArrayList.next();
      if ((!localtnz.a()) && (!TextUtils.isEmpty(localtnz.a))) {
        localArrayList.add(localtnz.a);
      }
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_a_of_type_Int = paramInt;
    int i;
    if ((paramtjs instanceof tkg))
    {
      paramArrayList = (tkg)paramtjs;
      if (paramArrayList.a != null)
      {
        i = paramArrayList.a.jdField_a_of_type_Int;
        this.b = i;
        label129:
        i = this.jdField_a_of_type_JavaUtilList.size();
        if (paramtjs != null) {
          break label186;
        }
      }
    }
    label186:
    for (paramArrayList = "";; paramArrayList = paramtjs.toString())
    {
      urk.a("Q.qqstory.player:HoriziotalVideoCoverListDataProvider", "setDataList , verticalPosition = %d , size = %d, groupId= %s, msgTabNodeType=%d", Integer.valueOf(paramInt), Integer.valueOf(i), paramArrayList, Integer.valueOf(this.b));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjn
 * JD-Core Version:    0.7.0.1
 */