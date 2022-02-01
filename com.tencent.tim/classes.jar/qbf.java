class qbf
  implements qdt
{
  qbf(qbc paramqbc) {}
  
  public void onCancel()
  {
    if (qbc.a(this.b) != null) {
      qbc.a(this.b).we(-1);
    }
  }
  
  public void onClick(int paramInt)
  {
    qbc.a(this.b).vU(paramInt);
    if (qbc.a(this.b) != null) {
      qbc.a(this.b).vU(paramInt);
    }
  }
  
  public void onDismiss()
  {
    if (qbc.a(this.b) != null) {
      qbc.a(this.b).onDismiss();
    }
  }
  
  public void onShow()
  {
    if (qbc.a(this.b) != null) {
      qbc.a(this.b).bnD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbf
 * JD-Core Version:    0.7.0.1
 */