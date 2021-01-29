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
- Added at buttons for changing activities, edit text field for performing input manipulations and handled behaviour using functions from controller.
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

