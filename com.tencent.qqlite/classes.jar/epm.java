import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;

class epm
  implements Runnable
{
  epm(epl paramepl, TroopUploadingThread.UploadState paramUploadState) {}
  
  public void run()
  {
    AvatarWallAdapter.m = 0;
    this.jdField_a_of_type_Epl.a.n = 0;
    int i = this.jdField_a_of_type_Epl.a.b - this.jdField_a_of_type_Epl.a.j;
    if (i >= 8) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 1) {
            break;
          }
          this.jdField_a_of_type_Epl.a.a(i, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.b, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.c);
        } while (this.jdField_a_of_type_Epl.a.a(this.jdField_a_of_type_Epl.a.g));
        this.jdField_a_of_type_Epl.a.d = false;
        this.jdField_a_of_type_Epl.a.b();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.a != 2);
      str = this.jdField_a_of_type_Epl.a.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopUploadingThread$UploadState.b);
    } while (str == null);
    this.jdField_a_of_type_Epl.a.a(str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     epm
 * JD-Core Version:    0.7.0.1
 */