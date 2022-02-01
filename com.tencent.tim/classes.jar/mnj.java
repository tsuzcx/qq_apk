import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class mnj
  implements mnf.b
{
  private mnf.a jdField_a_of_type_Mnf$a;
  private mnf.c jdField_a_of_type_Mnf$c;
  
  public mnj(mnf.a parama)
  {
    this.jdField_a_of_type_Mnf$a = parama;
  }
  
  public void a(@Nullable ColumnInfo paramColumnInfo, @NotNull mmx parammmx)
  {
    if (QLog.isColorLevel())
    {
      if (paramColumnInfo != null) {
        QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic srcColumnInfo : " + paramColumnInfo.toString());
      }
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: editTopic columnPublishInfo : " + parammmx.toString());
    }
    paramColumnInfo = new ColumnInfo(parammmx);
    paramColumnInfo.source = 5;
    if (this.jdField_a_of_type_Mnf$c == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: editColumn view is null!");
      return;
    }
    this.jdField_a_of_type_Mnf$c.aQw();
    this.jdField_a_of_type_Mnf$a.b(paramColumnInfo, new mnm(this, paramColumnInfo));
  }
  
  public void a(@NotNull mmx parammmx)
  {
    ColumnInfo localColumnInfo = new ColumnInfo(parammmx);
    this.jdField_a_of_type_Mnf$a.d(localColumnInfo);
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: saveColumnSketch column = " + parammmx.toString());
    }
  }
  
  public void a(mnf.c paramc)
  {
    this.jdField_a_of_type_Mnf$c = paramc;
  }
  
  public void a(@NotNull mql parammql, @NotNull String paramString)
  {
    if (this.jdField_a_of_type_Mnf$c != null) {
      this.jdField_a_of_type_Mnf$c.aQu();
    }
    parammql.a(new mnk(this, paramString));
    parammql.upload();
  }
  
  public void aQH()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: clearColumnSketch.");
    }
    this.jdField_a_of_type_Mnf$a.aQH();
  }
  
  public void aQI()
  {
    ColumnInfo localColumnInfo = this.jdField_a_of_type_Mnf$a.a();
    if ((localColumnInfo != null) && (this.jdField_a_of_type_Mnf$c != null)) {
      this.jdField_a_of_type_Mnf$c.a(localColumnInfo);
    }
    if (QLog.isColorLevel())
    {
      if (localColumnInfo != null) {
        QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: initFromSketch bindTopicData column = " + localColumnInfo.toString());
      }
    }
    else {
      return;
    }
    QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: initFromSketch bindTopicData column is null.");
  }
  
  public void b(@NotNull mmx parammmx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.ManageColumnPresenter", 2, "ManageColumnPresenter: createColumn columnPublishInfo : " + parammmx.toString());
    }
    if (this.jdField_a_of_type_Mnf$c == null)
    {
      QLog.i("RIJUGC.ManageColumnPresenter", 1, "ManageColumnPresenter: createColumn view is null!");
      return;
    }
    parammmx = new ColumnInfo(parammmx);
    parammmx.source = 5;
    this.jdField_a_of_type_Mnf$c.aQw();
    this.jdField_a_of_type_Mnf$a.a(parammmx, new mnl(this, parammmx));
  }
  
  public void detachView()
  {
    this.jdField_a_of_type_Mnf$c = null;
  }
  
  public int pA()
  {
    return mix.pl();
  }
  
  public int pB()
  {
    return mix.pm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnj
 * JD-Core Version:    0.7.0.1
 */