How to view the Database from a Developer's standpoint
1. Download and install DB Browser for SQLite from    https://sqlitebrowser.org/dl/ 
2. In Android Studio, open the Device File Explorer on the right side bar (lower corner)
3. With your device explorer open, find the following folders:

     - data > user (if user doesn’t exist, skip to the following bullet point) > 0 > com.example.*NAME_OF_PACKAGE* > databases
     - data > data > com.example.*NAME_OF_PACKAGE* > databases

4. Right-click on databases and select save as. Save the files in an easy to find location (like Desktop or Downloads)
5. Open the DB Browser for SQLite, and click the Open Database button. Navigate to where you saved your files and select 
    the file that lacks '-shm' or '-wal' (the file you'll select should only be the name of the table)
6. Once the file is open, select the Browse Data tab from the toolbar (next to the Database Structure tab)
This file may contain multiple tables required for its processing, so if the table in question isn't showing, under that
    toolbar click the Table: dropdown menu and select the table in question. That should pull up the contents of our populated table.


For Development purposes and as of 3/20/19, our database contains android_metadata, interests, and root_master_table.
    A user's interests will be located in the interests table.