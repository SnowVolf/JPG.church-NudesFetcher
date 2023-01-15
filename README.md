# JPG.church NUDES FETCHER
This tool is used to collect image links from given file from https://jpg.church/ such of leaks or nudes

## How to use
 - Go to gallery url via your browser
 - Save page as HTML (Menu -> Save -> Only HTML) or press [`Ctrl + S`]
 - Rename file to some simple name and copy it to some folder (for example: `E:\test.htm`) 
 - Compile and run the tool (for example in Intellij IDEA)
 - Enter full path to file `E:\test.htm`
 - Enter a regular expression for extraction 
 - ![Console input start](/screens/console_start.png)
 - As of **January 2023** this regexp does work:
```java
https?:\/\/(www\.)?simp\d{1,50}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&\/\/=]*)
```
 - ![Console input end](/screens/console_end.png)
 - The links will be pasted directly in your console. You can save it in text file and import to [Free Download Manager](https://www.freedownloadmanager.org/) 
 - ![FDM Window](/screens/fdm_screen.png)

## Try the tool
You can try to extract urls from test HTML page located in `/sample/` directory
