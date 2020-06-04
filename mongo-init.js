db.auth('admin-user', 'admin-password')

db = db.getSiblingDB('test-database')

db.createUser({
  user: 'test-user',
  pwd: 'test-password',
  roles: [
    {
      role: 'root',
      db: 'admin',
    },
  ],
})

db.employees.insert({
  name: "Pep",
  lastEventDate: '1985-04-23'  
})

db.employees.insert({
  name: "Joana",
  lastEventDate: '2015-08-15'  
});