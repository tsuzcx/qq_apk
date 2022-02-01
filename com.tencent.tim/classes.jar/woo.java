import com.tencent.qphone.base.util.QLog;

class woo
  implements wop.a
{
  woo(won paramwon, wop paramwop) {}
  
  public void yH(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      won.a(this.jdField_a_of_type_Won, this.jdField_a_of_type_Wop.getType());
      this.jdField_a_of_type_Wop.play();
      return;
    }
    QLog.e("FriendShipViewManager", 1, "director.prepare not ready, cannot play anim, type = " + this.jdField_a_of_type_Wop.getType());
    won.a(this.jdField_a_of_type_Won, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     woo
 * JD-Core Version:    0.7.0.1
 */