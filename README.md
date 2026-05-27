Developed a robust, crash-proof Point of Sale (POS) console application in Java, designed to simulate a fast-paced restaurant environment. Focused heavily on Object-Oriented best practices, data integrity, and cashier User Experience (UX).

Key Technical Achievements:

Data Integrity & Memory Management: Engineered deep-copy logic for menu items to prevent pass-by-reference bugs, ensuring cart modifications do not mutate the application's global state.

Resilient Architecture: Built a fault-tolerant input system using nested while loops and try-catch blocks, preventing NumberFormatExceptions from crashing the application during rapid data entry.

Advanced File I/O: Implemented read/write functionality to dynamically generate, save, and retrieve receipt histories using the java.io package.

Dependency Management: Integrated Maven to manage third-party libraries (AsciiTable), generating professional, dynamically formatted receipt grids.

UX & String Manipulation: Optimized cashier speed by implementing batch-processing for menu customization, utilizing regex and string splitting (.split(",")) to parse multiple items at once.

Type Safety: Utilized Enums (TacoSize, PaymentType, etc.) to strictly enforce valid data states and prevent typographical errors.
