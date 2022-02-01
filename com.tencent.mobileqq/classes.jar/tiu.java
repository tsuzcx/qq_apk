import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;

class tiu
  extends tgr
{
  private boolean jdField_a_of_type_Boolean;
  
  private tiu(tis paramtis, PTSItemView paramPTSItemView, BaseData paramBaseData)
  {
    super(paramPTSItemView, paramBaseData);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = tis.a(this.jdField_a_of_type_Tis, paramBaseData2);
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidViewView instanceof PTSItemView))) {
      ((ProteusItemData)paramBaseData2).a.layoutToView((PTSItemView)this.jdField_a_of_type_AndroidViewView, tis.a(this.jdField_a_of_type_Tis), true);
    }
    this.jdField_a_of_type_Boolean = true;
    tis.a(this.jdField_a_of_type_Tis, paramBaseData1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tiu
 * JD-Core Version:    0.7.0.1
 */