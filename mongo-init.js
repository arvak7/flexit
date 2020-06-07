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
  lastEventDate: ISODate("1985-04-23T00:00:00.000Z")
})

db.employees.insert({
  name: "Joana",
  lastEventDate: ISODate("2015-08-15T00:00:00.000Z")
})

db.employees.insert({
  name: "Nina",
  lastEventDate: ISODate("2012-12-12T00:00:00.000Z")
})

db.employees.insert({
  name: "Miquel",
  lastEventDate: ISODate("1999-09-19T00:00:00.000Z")
})

db.employees.insert({
  name: "Rosa"
})