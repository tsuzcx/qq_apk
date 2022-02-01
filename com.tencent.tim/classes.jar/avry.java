import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class avry
{
  private static avry a;
  public avpo<String> a;
  public avpo<String> b = new avpo(10);
  public avpo<String> c = new avpo(10);
  
  private avry()
  {
    this.jdField_a_of_type_Avpo = new avpo(5);
  }
  
  public static avry a()
  {
    try
    {
      if (jdField_a_of_type_Avry == null) {
        jdField_a_of_type_Avry = new avry();
      }
      avry localavry = jdField_a_of_type_Avry;
      return localavry;
    }
    finally {}
  }
  
  public String Gh()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activityNameQueue:\n");
    if (this.jdField_a_of_type_Avpo != null) {
      localStringBuilder.append(this.jdField_a_of_type_Avpo).append("\n");
    }
    localStringBuilder.append(" \n activityEventQueue:\n");
    if (this.b != null) {
      localStringBuilder.append(this.b);
    }
    localStringBuilder.append(" \n userActionQueue:\n");
    if (this.c != null) {
      localStringBuilder.append(this.c);
    }
    return localStringBuilder.toString();
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, View paramView, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ").append(paramString);
    if (paramViewGroup != null) {
      localStringBuilder.append("parent id: ").append(paramViewGroup.getId());
    }
    if (paramView != null) {
      localStringBuilder.append("view id: ").append(paramView.getId());
    }
    localStringBuilder.append(" onItemclick view  position:0x").append(Integer.toHexString(paramInt));
    localStringBuilder.append(" id").append(paramLong);
    a().aaj(localStringBuilder.toString());
  }
  
  public void aah(String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_Avpo != null))
    {
      if (this.jdField_a_of_type_Avpo.isFull()) {
        this.jdField_a_of_type_Avpo.remove();
      }
      this.jdField_a_of_type_Avpo.add(paramString);
    }
  }
  
  public void aai(String paramString)
  {
    if ((paramString != null) && (this.b != null))
    {
      if (this.b.isFull()) {
        this.b.remove();
      }
      this.b.add(paramString);
    }
  }
  
  public void aaj(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (this.c != null)
      {
        if (this.c.isFull()) {
          this.c.remove();
        }
        this.c.add(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("RDMEtraMsgCollector", 2, "", paramString);
    }
  }
  
  public void addNoramlClickAction(String paramString, View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Actvity] ").append(paramString);
    if (paramView != null) {
      localStringBuilder.append("  click view  id:0x").append(Integer.toHexString(paramView.getId()));
    }
    aaj(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avry
 * JD-Core Version:    0.7.0.1
 */