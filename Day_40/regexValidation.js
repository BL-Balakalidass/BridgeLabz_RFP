console.log("====== REGEX VALIDATION ======");

// ---------------- PIN CODE ----------------
const pinRegex = /^[0-9]{3}\s?[0-9]{3}$/;

const pinTests = [
    "400088",
    "400 088",
    "A400088",
    "400088B",
    "4000 88"
];

console.log("\nPIN Code Validation:");
pinTests.forEach(pin =>
    console.log(pin, "=>", pinRegex.test(pin))
);

// ---------------- EMAIL ----------------
const emailRegex =
/^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\.[a-zA-Z]{2,})$/;

const validEmails = [
    "bala@yahoo.com",
    "bala-100@yahoo.com",
    "bala.100@yahoo.com",
    "bala@com",
    "bala-100@net",
    "bala.100@com.au",
    "bala@1.com",
    "bala@gmail.com.com",
    "bala+100@gmail.com"
];

const invalidEmails = [
    "bala",
    "bala@.com.my",
    "bala@gmail.a",
    "bala@.com",
    "bala123@.com.com",
    ".bala@com",
    "bala()*@gmail.com",
    "bala@%*.com",
    "bala..2002@gmail.com",
    "bala.@gmail.com",
    "bala@gmail.com",
    "bala@gmail.com.1a",
    "bala@gmail.com.aa.au"
];

console.log("\nValid Email Tests:");
validEmails.forEach(email =>
    console.log(email, "=>", emailRegex.test(email))
);

console.log("\nInvalid Email Tests:");
invalidEmails.forEach(email =>
    console.log(email, "=>", emailRegex.test(email))
);

console.log("\n====== END ======");
