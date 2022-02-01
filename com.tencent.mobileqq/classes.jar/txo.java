import com.tencent.mm.opensdk.modelbase.BaseResp;

class txo
  implements biyn
{
  txo(txn paramtxn) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((txn.a(this.a) == null) || (!txn.a(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      znl.a(1, 2131718766);
      bool = false;
    }
    for (;;)
    {
      uva.a.a(bool);
      return;
      znl.a(2, 2131718784);
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     txo
 * JD-Core Version:    0.7.0.1
 */