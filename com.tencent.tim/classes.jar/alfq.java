import QC.UniBusiGetOneItemWithCheckRsp;

class alfq
  implements acci
{
  alfq(alfl paramalfl, alfl.a parama) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    alfl.a locala;
    if (this.jdField_b_of_type_Alfl$a != null)
    {
      if (!(paramObject instanceof UniBusiGetOneItemWithCheckRsp)) {
        break label50;
      }
      locala = this.jdField_b_of_type_Alfl$a;
      if (((UniBusiGetOneItemWithCheckRsp)paramObject).ret != 0) {
        break label45;
      }
    }
    label45:
    for (paramBoolean = true;; paramBoolean = false)
    {
      locala.a(paramBoolean, (UniBusiGetOneItemWithCheckRsp)paramObject);
      return;
    }
    label50:
    this.jdField_b_of_type_Alfl$a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfq
 * JD-Core Version:    0.7.0.1
 */