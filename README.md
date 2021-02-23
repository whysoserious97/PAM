#PAM
---
# Laboratory work No. 1 - App basic setup
---
## Author : Lesco Andrei
---
In laboratory work No.1 I was performing basic setup of mobile application on Android.



# Laboratory work task performed:

 - Created mobile application on Android
 - Createated 2 screens which transfer data from one screen to another
- Performed some data changes to data I have received in screen No. 2 and pass it back to screen No. 1
- Added buttons for changing activities, edit text field for performing input manipulations and handled behaviour using functions from controller.
- Changed Icon of the app to custom one

# Example of behaviour handling
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(getApplicationContext(),"Come back later", Toast.LENGTH_SHORT).show();
    }
    
# Example of action handling using intent
    fun next(view: View){
        val input = inputText.text.toString()
        val intent = Intent(this,Activity2::class.java)
        intent.putExtra("input",input)
        startActivity(intent)
    }

LAB 2 : Instagram Utility
App functions to implement in furthure labs:
1) Show the persons who do not follow you, but you follow them
2) Auto-Like photos of the persons in the list
3) For influencers to like all photoes of a random person from the persons who follows him (as an award for winning in a contest)
4) I am thinking to implement the functionality of sending messages broadcast to groups of people,but not being part of a group. Like sending general holiday congratulations like "Happy New Year", or inviting people to a party without reavealing who didn't accepted 

In laboratory work No.2 I have implemented basic layout and UI for my mobile application.



# Laboratory work task performed:

 - Picked the theme for my app, and it is Instagram Helper Utility.
 - Added 4 functional screens: sign in page, main menu, unfollow page and auto-like page

In unfollow and auto-like page I am using RecyclerView to display a list of person of each one



# Example of behaviour handling
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(getApplicationContext(),"Come back later", Toast.LENGTH_SHORT).show();
    }
    
# Example of action handling using intent
    fun next(view: View){
        val input = inputText.text.toString()
        val intent = Intent(this,Activity2::class.java)
        intent.putExtra("input",input)
        startActivity(intent)
    }